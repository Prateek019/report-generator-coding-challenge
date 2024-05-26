<h2>Report Generator</h2>

<h4>
This is a report generation application that can read input from various sources and write the report output to the respective sources.
</h4>
<h5>Currently its implementation is restricted to console input & output but it has been kept modular & extendable to extend it for other sources with minimal changes</h5>

<div>
<h3> Tech specifications </h3>
<div>
 <p>1. Language : Java 18 </p> 
 <p>2. Build tool : Maven 3.1</p> 
 <p>3. Unit testing : Junit 4.13.2</p>
</div>
</div>

<div>
<h3> Setup Steps </h3>
<div>
 <p>1. Git checkout this repository & branch </p>    
 <p>2. Run maven build command : mvn clean install </p>
 <p>3. Check for successful compilation of the code </p>
 <p>4. Jar named <b>report-generator-1.0-RELEASE.jar</b> should be generated under target folder</p>
</div>
</div>

<div>
<h3>Execution Steps</h3>
<div>
 <p>1. Run the jar obtained from above step using the below command </p>
 <p>2. <b>java -jar report-generator-1.0-RELEASE.jar</b></p>
 <p>3. The console will prompt for input</p>
 <p>4. Enter the multiline input with each row separated by newline & each value in a row separated by comma</p>
 <p> eg: <br>
         &nbsp&nbsp&nbsp   2343225,2345,us_east,RedTeam,ProjectApple,3445s <br>
         &nbsp&nbsp&nbsp   1223456,2345,us_west,BlueTeam,ProjectBanana,2211s <br>
        
 </p>
 <p> will be read as a single input with 2 lines and each line having 6 fields </p>
</div>
</div>

<div>
<h3>Sample Input</h3>
<div>
    <p>
        2343225,2345,us_east,RedTeam,ProjectApple,3445s <br>
        1223456,2345,us_west,BlueTeam,ProjectBanana,2211s <br>
        3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s <br>
        1233456,2345,us_west,BlueTeam,ProjectDate,2221s <br>
        3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s <br>
    </p>
    <p> An empty line after the input denotes end of input </p>
</div>

<h3>Sample Output</h3>
<div>
    <p>
        *************** REPORT **************** <br>
        The number of unique customerId for each contractId : {2346=2, 2345=3} <br>
        The number of unique customerId for each geozone : {eu_west=2, us_west=2, us_east=1} <br>
        The list of unique customerId for each geozone : {eu_west=3244132,3244332, us_west=1233456,1223456, us_east=2343225} <br>
        The average buildduration for each geozone : {eu_west=4222.0s, us_west=2216.0s, us_east=3445.0s} <br>
    </p>
</div>
</div>

<div>
<p><b>A screenshot of console based execution of above input is added to this git repo:</b></p>
<p>path : </p>
</div>

<div>
<h3>Development details</h3>
    <div>
    <h4>Design Patterns used</h4>
    <p>1. <b>Factory Design Pattern</b> : To have a factory method return the report metrics generation instance of the class based on the type of report needed. The report is generated for 2 params right now, contractId & geozone (as per the requirement). System has been designed to extend it to support multiple params to with minimal changes</p>
    <p>2. <b>Strategy Design Pattern</b> : To have a single generic interface with multiple implementations eg: InputService, ReportService to support input from multiple sources and report generation for respective multiple sources. Currently to display this capability 2 sources have been mentioned, consoleBased & fileBased, but implementation has been done only for console based. A placeholder class has been added to just show the scalability of the system for multiple sources.</p>
    </div>
</div>

<div>
<h4>The system has been built keeping in mind the SOLID design principals for development maintaining code modularity, readability & scalability</h4> 
</div>

<div>
<h3>Unit Test Cases</h3>
<div>
    <p>1. Total 8 unit test cases are present to test the core logics of the system</p>
    <p>2. <b>MetricGenerationTest</b> class has unit tests to assert the metrics & their values generated for the report  </p>
    <p>3. <b>ValidationUtilsTest</b> class has unit tests to assert the data validation rules for the raw input obtained</p>
</div>
</div>
