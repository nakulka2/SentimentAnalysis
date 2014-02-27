SentimentAnalysis
=================

SentimentAnalysis tool

02/26/2014:
This is the initial phase of Sentiment Analysis tool. 
Goals of initial phase:
Step 1:Develop a simple module to consume live twitter data and save it to local filesystem in the form of a text file.
Step 2:Process the file using PigLatin
Step 3:Develop a sentiment analysis module and run it using YARN/ MapReduce

Status as of 02/26/2014:
Step 1:Implemented
Step 2:To be started
Step 3:Design ready

Steps to run step 1:
Run the TwitterStream-1.0-SNAPSHOT.jar:
java -cp TwitterStream-1.0-SNAPSHOT.jar com.twitter.stream.UI
You will get the 2 swing UIs (screenshot 1 and screenshot 2) on your screen. Enter the details asked in screenshot 1.
Note that you need to have a twitter application registered to get your own credentials(or use mine from screenshot 1 
assuming they are still valid). Let the process run in the backgroud and then enjoy the live twitter feeds saved on
your local filesystem. 

I recently used this to pull live twitter data during the superbowl match. Once step 3 is complete I plan to analyze the
sentiments of Broncos supporters :)
