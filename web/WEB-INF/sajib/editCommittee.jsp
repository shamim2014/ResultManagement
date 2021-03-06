<%-- 
    Document   : editCommittee
    Created on : Feb 24, 2015, 9:17:21 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>EditExamCom</title>
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
						
							<label> Session: </label> <input type="text" id="session" name="session" class="required input_field" />
							<div class="cleaner_h10"></div>
						   <label> Year: </label> <select  id="year" name="year" class="select"/>
							 <option value="1st">1st Year</option>
							 <option value="2nd">2nd Year</option>
							 <option value="3rd">3rd Year</option>
							 <option value="4th">4th Year</option>
							 <option value="ms">Masters</option>
							 </select>
							 <div class="cleaner_h10"></div>
						   <label> Chairman Name: </label> <input type="text" id="chairman_name" name="chairman_name" class="required input_field" />
							<div class="cleaner_h10"></div>
							<label for="user">Chairman Email: </label> <input type="text" id="chairman_id" name="chairman_id" class="required input_field" />
							<div class="cleaner_h10"></div>
							<label for="user">Member Name: </label> <input type="text" id="1stmem_name" name="1stmem_name" class="required input_field" />
							<div class="cleaner_h10"></div>
							<label for="user">Member Email: </label> <input type="text" id="1stmem_id" name="1stmem_id" class="required input_field" />
							<div class="cleaner_h10"></div>
							<label for="user">Member Name: </label> <input type="text" id="2ndmem_name" name="2ndmem_name" class="required input_field" />
							<div class="cleaner_h10"></div>
							<label for="user">Member Email: </label> <input type="text" id="2ndmem_id" name="2ndmem_id" class="required input_field" />
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