# Example project

This repository contains a spring boot project in witch we can test the 
checkstyle python pie chart plugin.

## How to start:

To generate the project site and reports run:
```shell
./mvnw example/site
  ```
The report files will be found in ```example/target/site```, specifically the file of interest is
```checkstyle.html``` which can be opened via any browser.

To customize the rules you can edit the ```checkstyle.xml``` file and follow the instructions
of the opening comments.

Then in order to run the plugin you need to have python installed on your machine and run the
following command to install the necessary libraries:
```shell
python pip install -r example/scripts/requirements.txt
 ```
Finally, run the following to start the script:
```shell
python example/main.py
 ```
Csv files and png images will be saved in  ```example/target/output```.
