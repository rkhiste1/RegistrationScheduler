[
  adopted from http://www.cs.rochester.edu/u/www/courses/171/Fall-03/files/readme.txt
  by Deger Cenk Erdil
  for CS654 Distributed Systems
  This is a template README file about how you should form your own README file.
  In general,
        you should remove anything in between square brackets (i.e. [..]), and
        you should replace anything in between <> with a value.
]

CS542 Design Patterns
Fall 2016
PROJECT Assignment 2 README FILE

Due Date: Friday, September 30, 2016
Submission Date: Friday, September 30, 2016
Grace Period Used This Project: <DAYS> Days
Grace Period Remaining: <DAYS> Days
Author(s): Rasika Makarand Khiste
e-mail(s): rkhiste1@binghamton.edu


PURPOSE:

[
  The purpose of this assignment is to learn application of 
  design principles for a simple multi-threaded application.
]

PERCENT COMPLETE:

[
  I believe I have completed 100% of this project.
]

PARTS THAT ARE NOT COMPLETE:

[
  None
]

BUGS:

[
  None
]

FILES:

[
  Included with this project are 14 files:

  Driver.java: Main class file that takes arguments, validate them,
  and calls methods of other classes 
  Student.java: Class file responsible for course assignment
  for 7 courses
  FileDisplayInterface.java: Interface that declares method to write ouput to the file
  StdoutDisplayInterface.java: Interface that declares method to write
  output to standard output display
  StoreResultInterface.java: Interface that declares method to store results
  Results.java: Stores and displays results
  CreateWorkers.java: Class that creates given number of threads, start them
  and joins on them
  WorkerThread.java: Implements Runnable interface, has thread's run() method.
  FileProcessor.java: Reads given input file line by line
  Logger.java: Sets given debug value and writes message to standard output
  as per debug value
  ObjectPool.java: Manages 7 courses as a pool of objects
  ObjectPoolInterface.java: Interface that declares methods that are required
  to manage the objects in object pool. 
  build.xml: file responsible to build, compile, compress and run the project
  README.txt: The file you are currently reading
  
]

SAMPLE OUTPUT:

[
  remote04:~/CS542/rasika_khiste_assign2/rasika_khiste/registrationScheduler> ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=3 -Darg3=0
Buildfile: /import/linux/home/rkhiste1/CS542/rasika_khiste_assign2/rasika_khiste/registrationScheduler/src/build.xml

jar:
      [jar] Building jar: /import/linux/home/rkhiste1/CS542/rasika_khiste_assign2/rasika_khiste/registrationScheduler/BUILD/jar/registrationScheduler.jar

run:
     [java] 
     [java]  The inputFile args[0] is: input.txt
     [java]  Student_1 F D A B C 15
     [java]  Student_2 A D G E F 15
     [java]  Student_3 E F G C A 15
     [java]  Student_4 F G D A B 15
     [java]  Student_5 C F A G B 15
     [java]  Student_6 E D B G C 15
     [java]  Student_7 C F G E B 15
     [java]  Student_8 G A E C D 15
     [java]  Student_9 A G F C D 15
     [java]  Student_10 A D C E F 15
     [java]  Student_11 B C E A G 15
     [java]  Student_12 G E C D A 15
     [java]  Student_14 G C A D E 15
     [java]  Student_13 G F C E A 15
     [java]  Student_16 C G F D E 15
     [java]  Student_17 D C E G B 15
     [java]  Student_19 C G B F D 15
     [java]  Student_20 D E F A B 15
     [java]  Student_15 E D B C A 15
     [java]  Student_21 G E D F C 15
     [java]  Student_22 C A F E B 15
     [java]  Student_23 G B C F E 15
     [java]  Student_18 E B D C G 15
     [java]  Student_25 G E B A C 15
     [java]  Student_24 D E G A B 15
     [java]  Student_26 C G D F E 15
     [java]  Student_27 B A C D E 15
     [java]  Student_28 A E C F B 15
     [java]  Student_29 D F A C E 15
     [java]  Student_30 D C F A E 15
     [java]  Student_31 D A C B G 15
     [java]  Student_32 B A C G E 15
     [java]  Student_33 A G F B D 15
     [java]  Student_34 E A D B F 15
     [java]  Student_35 B F G E C 15
     [java]  Student_36 C D B G F 15
     [java]  Student_37 G E A F C 15
     [java]  Student_38 C D F B G 15
     [java]  Student_39 F G D A C 15
     [java]  Student_40 D A G E F 15
     [java]  Student_41 E A F B C 15
     [java]  Student_42 F B A E G 15
     [java]  Student_43 G B E D F 15
     [java]  Student_44 G D B C A 15
     [java]  Student_45 D G F E B 15
     [java]  Student_46 E A B D G 15
     [java]  Student_47 D E A G F 15
     [java]  Student_48 A C D E B 15
     [java]  Student_49 C G B E F 15
     [java]  Student_50 C F B A D 15
     [java]  Student_51 A F C D G 15
     [java]  Student_52 B D A E G 15
     [java]  Student_53 D E B G A 15
     [java]  Student_54 A G E B D 15
     [java]  Student_55 B E F D G 15
     [java]  Student_56 D B C F E 15
     [java]  Student_57 C D B A E 15
     [java]  Student_58 G D B E A 15
     [java]  Student_59 E D A G C 15
     [java]  Student_60 A F E C D 15
     [java]  Student_61 D B F A C 15
     [java]  Student_62 B F E A G 15
     [java]  Student_63 E C G F B 15
     [java]  Student_64 A B E F D 15
     [java]  Student_65 C D A F G 15
     [java]  Student_66 F G B A C 15
     [java]  Student_67 D A E C G 15
     [java]  Student_68 A D F G B 15
     [java]  Student_69 F A E B D 15
     [java]  Student_70 F G A E D 15
     [java]  Student_71 B A D F E 15
     [java]  Student_72 F G E D B 15
     [java]  Student_73 A C B F G 15
     [java]  Student_74 C F G D A 15
     [java]  Student_75 A E F C G 15
     [java]  Student_76 F E D B A 15
     [java]  Student_77 E F A B C 15
     [java]  Student_78 D C G F A 15
     [java]  Student_79 F C D A E 15
     [java]  Student_80 E F B D C 16
     [java] Average preference value is: 15.0
     [java] Average preference value is: 15.0

BUILD SUCCESSFUL
Total time: 1 second

]

TO COMPILE:

[
  ant -buildfile src/build.xml all
]

TO RUN:

[
  ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=3 -Darg3=0
]

CHOICE OF DATA STRUCTURES:

[
  I have used an Array data structure to store list of students. I preferred array
  over ArrayList, as number of students were given as 80 (fixed no.), which
  makes it space efficient in this case.

  I have used ArrayList to store results in Results class,  
  as ArrayList has many more methods to manipulate list items, like solo
  modifications, iteration, which is more flexible in updating stored
  entries, when multiple threads are accessing and modifying the entries
  from results data structure.
  Also, this is open for extension if more entries need to be added
  in results data structure later on.
]

EXTRA CREDIT:

[
  N/A
]


BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.

[
  Head First Design Patterns by O'Reilly Media
  http://docs.oracle.com/javase/6/docs/api/java/text/DecimalFormat.html
  https://docs.oracle.com/javase/7/docs/api/java/io/BufferedWriter.html
  https://docs.oracle.com/javase/tutorial/essential/concurrency/simple.html
]

ACKNOWLEDGEMENT:

[
  
]
