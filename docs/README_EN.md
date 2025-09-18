## konachan.net Website Parser

![Preview site](./docs/data/header.png)

This is a Java application that downloads images from [konachan.net](https://konachan.net) to a directory you specify.

___

## Usage

> **Java required to use the application!**

***Download:***
Download the latest version of the Java script in [releases](https://github.com/Borukofu/downloader-image-from-konachan.net/releases) on Github

***Usage:***

```bash
java -jar app.jar -o ./images -tf ./tags.txt -p 0
```

___

## Manual assembly and use

> **To build and use the application, you need to have `Java-jdk` and `git` installed!**J

***Loading:***

```bash
git clone https://github.com/Borukofu/downloader-image-from-konachan.net
git switch src
```

***Compilation:***

```bash
javac app.java
```

***Usage:***

```bash
java app -o ./images -tf ./tags.txt -p 0
```

### Command Line Parameters

* `-o <directory_path>`: Specifies the directory where the images will be downloaded. Example: -o ./images
* `-tf <tags_file_path>`: Specifies the path to a text file containing tags for filtering images. Example file: [example](./data/example_tag.txt)
* `-p <page_number>`: Specifies the page number on konachan.net to parse.

___

## Tips

* If no images are found on the specified konachan.net page, try changing the page number.
* Make sure you have write permissions to the specified directory for saving images.
* The tags file should contain each tag on a separate line.

___

## Source Code

The project source code is available in the `src` branch on GitHub: [branch](https://github.com/Borukofu/downloader-image-from-konachan.net/tree/src)