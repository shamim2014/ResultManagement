function login(p)
{
    var str="<div class='input_class'><form action='login' method='post'>";
    if(p==="office")
    {
        str +="<input type='hidden' name='who' value='official' />";              
    }
    else if(p==="committee")
    {
        str +="<input type='hidden' name='who' value='committee' />"; 
    }
    else if(p==="teacher")
    {
        str +="<input type='hidden' name='who' value='teacher' />"; 
    }
    
    str+="<div class='label'><div class='input_name'>Email</div><div class='label_input'><input name='email' type='text'/></div></div><div class='label'><div class='input_name'>Password</div><div class='label_input'><input name='passWord' type='password'/></div></div><div class='submit_btn'><input type='submit' value='login'/></div></form></div>";
    var x = document.getElementById("loginRequest");
    x.innerHTML=str;
}