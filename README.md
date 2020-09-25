**jDiskMark** is a disk io benchmarking utility written in java, kindly made public by jamesmarkchan in https://sourceforge.net/projects/jdiskmark/  and protected under BSD License and Apache License V2.0.  See that repository for more detailed readme about functionality

This repo is for use by a Computer Methodology class, the changes may be unstable. Use the versions at https://sourceforge.net/projects/jdiskmark/ for more reliable source.

This code does what is necessary to satisfy its requirements, but it is not (yet) particularly object oriented, nor is it (yet) particularly extensible, no coincidence there :-) So for the time being we will call it **"BadBM"** and we will learn how to turn it into **GoodBM**.
 
**Product Description**
The purpose of this program is to compute and provide some performance information about the local disk drive associated with the user’s home directory. It obtains this information by executing a series of write and/or read operations against the disk and measuring the throughput over time. The benchmarks to be executed are defined by allowing the user to select whether to do a ‘read’, ‘write’ or ‘write-read’ benchmark and to indicate how sizeable the benchmark test data should be as well as some other parameters. A GUI is provided to request all of this information and to allow the user to start, stop and monitor the benchmark. An X/Y graph is produced dynamically during each ‘run to show the progress and disk performance. A history of runs with all performance data is maintained in a persistent location and is visible in the GUI, and any significant events or errors encountered are presented in the GUI.


**Usage**

To Execute the program:
-	**From an IDE** – Locate the main() method in App.java, if the IDE is set up to recognize this as a Java project, there should be an icon to the left of the main() method you can click to start running it. After starting it will take some time to start up, and some messages will be logged to the console. If its running you should see a new window with a “Java Coffeecup” as its icon. Go to that application, click on the ”Data Location” tab to configure a location on your disk where temporary benchmark files should be placed. It will remember this configuration for the future. 

You can now click “Start” on top left of window to start a benchmark. If its is running properly, the chart on top should get populated with the performance info for the benchmark.

-	**From a command prompt** – Go to the project’s folder, e.g. lcmbadbm. Locate the folder where the IDE has placed the compiled class files, e.g. “out/production/lcmbadbm” (you should see a folder tree starting with “edu”, containing all of the packages and class files). Execute the program as follows (replace the folder name if necessary)

For UNIX/Mac:      

	java  -cp out/production/lcmbadbm:libs/*  edu.touro.mco152.bm.App

For Windows native or Git Bash command line (must use semicolon instead of colon for path separator):    

	java  -cp “out/production/lcmbadbm;libs/*  edu.touro.mco152.bm.App



Note that the jdm.properties file gets updated when the program is executed, and options you choose are available for subsequent runs. You do not need to check this file back in if changed.

Note that the locationDir property in jdm.properties is used to point to the location for the benchmark data files produced during execution. It gets set to the users home directory if not set already. If it is set and its wrong, execution of a benchmark will fail.

