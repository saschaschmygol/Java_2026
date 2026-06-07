$libDir = "lib"

if (!(Test-Path $libDir)) {
    New-Item -ItemType Directory -Path $libDir
}

$files = @(
    "https://repo1.maven.org/maven2/org/apache/poi/poi/5.2.3/poi-5.2.3.jar",
    "https://repo1.maven.org/maven2/org/apache/poi/poi-ooxml/5.2.3/poi-ooxml-5.2.3.jar",
    "https://repo1.maven.org/maven2/org/apache/poi/poi-ooxml-lite/5.2.3/poi-ooxml-lite-5.2.3.jar",

    "https://repo1.maven.org/maven2/org/apache/xmlbeans/xmlbeans/5.1.1/xmlbeans-5.1.1.jar",

    "https://repo1.maven.org/maven2/org/apache/commons/commons-compress/1.21/commons-compress-1.21.jar",
    "https://repo1.maven.org/maven2/commons-io/commons-io/2.11.0/commons-io-2.11.0.jar",
    "https://repo1.maven.org/maven2/org/apache/commons/commons-collections4/4.4/commons-collections4-4.4.jar",

    "https://repo1.maven.org/maven2/com/github/virtuald/curvesapi/1.07/curvesapi-1.07.jar",

    "https://repo1.maven.org/maven2/org/apache/logging/log4j/log4j-api/2.18.0/log4j-api-2.18.0.jar",
    "https://repo1.maven.org/maven2/org/apache/logging/log4j/log4j-core/2.18.0/log4j-core-2.18.0.jar"
)

foreach ($file in $files) {
    $fileName = Split-Path $file -Leaf
    $outputPath = Join-Path $libDir $fileName

    Write-Host "Скачивается: $fileName"
    Invoke-WebRequest -Uri $file -OutFile $outputPath
}

Write-Host ""
Write-Host "Готово! Все JAR-файлы скачаны в папку lib"