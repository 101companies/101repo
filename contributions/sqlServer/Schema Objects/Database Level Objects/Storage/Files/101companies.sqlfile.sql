ALTER DATABASE [$(DatabaseName)]
    ADD FILE (NAME = [101companies], FILENAME = '$(DefaultDataPath)$(DatabaseName).mdf', FILEGROWTH = 1024 KB) TO FILEGROUP [PRIMARY];

