# SQLiteSimple

A contribution implementing 101companies with plain SQL  ([SQLite](https://sqlite.org/)) without an embedding Language.

## Requirements

* [sqlite3  (command-line shell program)](https://sqlite.org/download.html)
* Makefile-support

## Implemented Features

* Hierarchical Company
* Singleton
* Total
* Cut
* Median

## Executing
All following commands will be executed on bin/company.db:

##### Creating the company-structure

    make setup

##### Deleting the company-structure

        make teardown

##### Using a supported 'Action'-Features


      make $feature


Please replace $feature with the desired Feature's name

## Testing
Execute the following and compare the results 'per Hand'

    make test

## Architecture

* In the doc-folder is the database-diagram used for this contribution.
* In the src-folder are the sql-scripts
* In the bin-folder are the databases (they are created at runtime)
