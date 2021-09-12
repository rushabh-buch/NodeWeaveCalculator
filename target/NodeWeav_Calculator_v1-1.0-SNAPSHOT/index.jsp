<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nodeweave Assessment : Simple Calculator</title>
    </head>
    <body>
        <div align="center">
        <h1>Nodeweave Assessment : Simple Calculator</h1>
        <form action="Calculate" method="post">
            <table border="2">
                <tr>
                    <td colspan="4">
                        <input style="width: 97%" type="text" disabled="true" name="text" value="${result}">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input style="width: 100%" type="submit" name="Last Operation" value="Last Operation">
                    </td>
                    <td colspan="2">
                        <input style="width: 100%" type="submit" name="Clear Memory" value="Clear Memory">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input style="width: 100%" type="submit" name="C" value="C" >
                    </td>
                    <td>
                        <input style="width: 100%" type="submit" name="Sqrt" value="Sqrt" >
                    </td>
                    <td>
                        <input style="width: 100%" type="submit" name="Pi" value="Pi" >
                    </td>
                    <td>
                        <input style="width: 100%" type="submit" name="/" value="/" >
                    </td>
                </tr>
                
                <tr>
                    <td>
                        <input style="width: 100%" type="submit" name="7" value="7">
                    </td>
                    <td>
                        <input style="width: 100%" type="submit" name="8" value="8">
                    </td>
                    <td>
                        <input style="width: 100%" type="submit" name="9" value="9">
                    </td>
                    <td>
                        <input style="width: 100%" type="submit" name="x" value="x">
                    </td>
                </tr>
                
                
                <tr>
                    <td>
                        <input style="width: 100%" type="submit" name="4" value="4">
                    </td>
                    <td>
                        <input style="width: 100%" type="submit" name="5" value="5">
                    </td>
                    <td>
                        <input style="width: 100%" type="submit" name="6" value="6">
                    </td>
                    <td>
                        <input style="width: 100%" type="submit" name="-" value="-">
                    </td>
                </tr>
                
                <tr>
                    <td>
                        <input style="width: 100%" type="submit" name="1" value="1">
                    </td>
                    <td>
                        <input style="width: 100%" type="submit" name="2" value="2">
                    </td>
                    <td>
                        <input style="width: 100%" type="submit" name="3" value="3">
                    </td>
                    <td>
                        <input style="width: 100%" type="submit" name="+" value="+">
                    </td>
                </tr>
                
                <tr>
                    <td>
                        <input style="width: 100%" type="submit" name="0" value="0">
                    </td>
                    <td>
                        <input style="width: 100%" type="submit" name="." value=".">
                    </td>
                    <td colspan="2">
                        <input style="width: 100%" type="submit" name="=" value="=">
                    </td>
                </tr>
            </table>
        </form>
                    <h3>Instructions</h3>
                    <ul>
                        <li><p>This calculator supports 9 digits whole number with 2 decimal place digits</p></li>
                        <li><p>If you exceed 9 digit whole number, the calculator will do nothing and display will not go beyond 9 digits.</p></li>
                        <li><p>If you exceed 2 decimal digits, the calculator will display nearest round off to 2 decimal places always.</p></li>
                        <li><p>You can perform continuous mathematical operations (For Example: 2+4*8-2)</p></li>
                        <li><p>The last operation button shows what the last calculation you performed. To get the answer of the last operation please hit = button.</p></li>
                        <li><p>To use the memory function, please make sure you have enabled cookies on your browser.</p></li>
                        
                        
                    </ul>
      </div>
    </body>
</html>
