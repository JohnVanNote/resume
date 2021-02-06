package com.jvn.resume.api.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jvn.resume.formatter.LatexFormatter;
import com.jvn.resume.formatter.LatexFormatter.Color;
import com.jvn.resume.formatter.LatexFormatter.FontFamily;
import com.jvn.resume.formatter.LatexFormatter.FontSize;
import com.jvn.resume.formatter.LatexFormatter.PaperSize;
import com.jvn.resume.formatter.LatexFormatter.Theme;
import com.jvn.resume.printer.FileSystemPrinter;
import com.jvn.resume.util.MapperFactory;
import com.jvn.resume.model.Resume;
import com.jvn.resume.printer.Printer;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileSystemStorageService implements StorageService {

  private final Path rootLocation;

  @Autowired
  public FileSystemStorageService(StorageProperties properties) {
    this.rootLocation = Paths.get(properties.getLocation());
  }

  @Override
  public void store(MultipartFile file) {
    try {
      if (file.isEmpty()) {
        throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
      }

      String inputFileName = file.getOriginalFilename();
      String inputFileBase = FilenameUtils.getBaseName(inputFileName);
      String inputFileExtension = FilenameUtils.getExtension(inputFileName);

      ObjectMapper mapper = MapperFactory.getMapper(inputFileExtension);
      String fileContents = new String(file.getBytes(), StandardCharsets.UTF_8);
      Resume resume = mapper.readValue(fileContents, Resume.class);

      Path outputPath = this.rootLocation.resolve(inputFileBase + ".tex");
      Printer printer = new FileSystemPrinter(resume, outputPath);
      printer.print(new LatexFormatter(Theme.BANKING, FontSize.ELEVEN, FontFamily.SANS, PaperSize.A4, Color.BLUE));
    } catch (IOException e) {
      throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
    }
  }

  @Override
  public Stream<Path> loadAll() {
    try {
      return Files.walk(this.rootLocation, 1)
          .filter(path -> !path.equals(this.rootLocation))
          .map(path -> this.rootLocation.relativize(path));
    } catch (IOException e) {
      throw new StorageException("Failed to read stored files", e);
    }

  }

  @Override
  public Path load(String filename) {
    return rootLocation.resolve(filename);
  }

  @Override
  public Resource loadAsResource(String filename) {
    try {
      Path file = load(filename);
      Resource resource = new UrlResource(file.toUri());
      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new StorageFileNotFoundException("Could not read file: " + filename);

      }
    } catch (MalformedURLException e) {
      throw new StorageFileNotFoundException("Could not read file: " + filename, e);
    }
  }

  @Override
  public void deleteAll() {
    FileSystemUtils.deleteRecursively(rootLocation.toFile());
  }

  @Override
  public void init() {
    try {
      Files.createDirectory(rootLocation);
    } catch (IOException e) {
      throw new StorageException("Could not initialize storage", e);
    }
  }

}
