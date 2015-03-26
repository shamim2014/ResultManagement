<%-- 
    Document   : editStudent
    Created on : Feb 24, 2015, 9:35:58 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>EditStudent</title>
<meta name="keywords" content="paint blog, free templates, website templates, CSS, HTML" />
<meta name="description" content="Paint Blog - free blog website template provided by TemplateMo.com" />
<link href="style.css" rel="stylesheet" type="text/css" />
<!--  Free CSS Template is designed by TemplateMo.com  -->
<!--[if lt IE 7]>
<style type="text/css">

  .date_section, .comment{ behavior: url(iepngfix.htc); }

</style>
<![endif]-->
</head>
<body>
<div id="templatemo_top_panel">
	<div id="templatemo_header_section">
    </div> <!-- end of header -->
</div>    
    
<div id="templatemo_menu_panel">
    <div id="templatemo_menu_section">
          <ul class="dropdown">
            <li><a href="home.html">Students</a>
			    <ul>
				     <li><a href="home.html">Insert Student</a></li>
					 <li><a href="home.html">Edit Student</a></li>
				</ul>
			</li>
            <li><a href="subpage.html">Teachers</a>
			    <ul>
				     <li><a href="home.html">Insert Teacher</a></li>
					 <li><a href="home.html">Edit Teacher</a></li>
				</ul>

			</li>
            <li><a href="#">Exam Committee</a>
			    <ul>
				     <li><a href="home.html">Insert Committee</a></li>
					 <li><a href="home.html">Edit Committee</a></li>
				</ul>

			</li>    
			<li><a href="#">Courses</a>
			    <ul>
				     <li><a href="home.html">Insert Course</a></li>
					 <li><a href="home.html">Edit Course</a></li>
					 <li><a href="home.html">Insert Course Teacher</a></li>
					 <li><a href="home.html">Edit Course Teacher</a></li>
				</ul>

			</li>
			<li><a href="#">Semester Info.</a>
			    <ul>
				     <li><a href="home.html">Insert</a></li>
					 <li><a href="home.html">Update</a></li>
				</ul>

			</li>
			<li><a href="#">Logout</a>                   
        </ul> 
    </div>
</div> <!-- end of menu -->

<div id="templatemo_content_panel">
	<div id="templatemo_content">
    	
        <div id="templatemo_content_left">
        	<div class="templatemo_content_left_section">
            	<div class="left_section_title">Students</div>
                <div class="left_section_content">
                	<ul>
                        <li><a href="subpage.html#">1st year</a></li>
                        <li><a href="#">2nd year</a></li>
                        <li><a href="#">3rd year</a></li>
                        <li><a href="#">4th year</a></li>
                    </ul>
                </div>
            </div>
            
            <div class="templatemo_content_left_section">
            	<div class="left_section_title">Teachers</div>
                <div class="left_section_content">
                	<ul>
                        <li><a href="#">See teacher profile</a></li>
                    </ul>
                </div>
            </div>
            
            <div class="templatemo_content_left_section">
            	<div class="left_section_title">Exam Committee</div>
                <div class="left_section_content">
                	<ul>	
                        <li> <a href="#">1st year</a></li>
                        <li><a href="#">2nd year</a></li>
                        <li><a href="#">3rd year</a></li>
                        <li><a href="#">4th year</a></li>
                    </ul>
                </div>
            </div>
         </div> <!-- end of content left -->
         
         <div id="templatemo_content_right">
        	<div class="templatemo_post_section">
                <div class="date_section">                 
                </div>
            	<div class="post_content">                	
                    <div id="contact_form2">
					  <form method="post" action="#">
						
						 <label> Registration Num: </label> <input type="text" id="reg_num" name="reg_num" class="required input_field" />
						<div class="cleaner_h10"></div>
						 <label>New Batch: </label> <input type="text" id="batch" name="batch" class="required input_field" />
						<div class="cleaner_h10"></div>
						<label>New Roll: </label> <input type="text" id="roll" name="roll" class="required input_field" />
						<div class="cleaner_h10"></div>
						 <label> Session:</label>  <select id="course_year" name="course_year" class="select"/>
						 <option value="1st">2014</option>
						 <option value="2nd">2015</option>
						 <option value="3rd">2016</option>
						 <option value="4th">2017</option>
						 </select>
						 <div class="cleaner_h10"></div>
						<label>New Exam Roll:</label> <input type="text" id="email" name="email" class="required input_field" />
						<div class="cleaner_h10"></div>
						
						<input type="reset" class="reset_btn" value="Reset" style="margin-left:280px;" />
						<input name="submit" type="submit" class="submit_btn" value="Insert" />
						</form>
					</div>                   
                </div>
            </div> <!-- end of 1 post -->
        </div> <!-- end of content right -->
        
		<div class="cleaner_with_height">&nbsp;</div>
    </div>
</div> <!-- end of content panel -->

<div id="templatemo_footer_panel">
    <div id="templatemo_footer_section">
       Department of Computer Science & Engineering,University of Dhaka
	   <br /> Science Complex Building,Mokarram Bhaban
		</div>
</div>
</body>
</html>