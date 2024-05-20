# checkstyle python pie chart

Python script to generate the csv files and graphs from a checkstyle xml file report generated with [Apache Maven Checkstyle Plugin](https://maven.apache.org/plugins/maven-checkstyle-plugin/index.html) for a Maven Java project.

## How to start
First of all you need to place this script in the root directory of your Java project, then copy the contents of the
```checkstyle-python-pie-chart/src``` directory into it.

Then in order to launch it you need to have python installed on your machine and run the following command
to install the necessary libraries:
```shell
  pip install -r scripts/requirements.txt
  ```
Then run the following to start the script:
```shell
  python main.py
  ```
Csv files and png images will be saved in ```target/output```.

### example:
![Checkstyle-charts](https://github.com/isaacmaffeis/checkstyle-python-pie-chart/assets/28917454/0fe5cd9f-fe03-4bae-b11e-00c7801ea229)
