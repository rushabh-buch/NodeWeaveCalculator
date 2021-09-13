/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nodeweav_calculator_v1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

/**
 *
 * @author Rushabh
 */
@WebServlet(name = "Calculate", urlPatterns = {"/Calculate"})
public class Calculate extends HttpServlet {
    
    private StringBuilder numberappender;
    private StringBuilder builder;
    private String result;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("0") != null) setZero();
        else if (request.getParameter("1") != null) setOne();
        else if (request.getParameter("2") != null) setTwo();
        else if (request.getParameter("3") != null) setThree();
        else if (request.getParameter("4") != null) setFour();
        else if (request.getParameter("5") != null) setFive();
        else if (request.getParameter("6") != null) setSix();
        else if (request.getParameter("7") != null) setSeven();
        else if (request.getParameter("8") != null) setEight();
        else if (request.getParameter("9") != null) setNine();
        else if(request.getParameter(".")!=null) setPoint();
        else if (request.getParameter("+") != null) setAddition();
        else if (request.getParameter("-") != null) setSubtraction();
        else if (request.getParameter("x") != null) setMultiplication();
        else if (request.getParameter("/") != null) setDivision();
        else if (request.getParameter("=") != null) setEquals(response);
        else if(request.getParameter("Sqrt") != null) setSqrt();
        else if(request.getParameter("Pi") != null) setPi();
        else if (request.getParameter("C") != null) clear();
        else if(request.getParameter("Last Operation") != null) LastOp(request);
        else if(request.getParameter("Clear Memory") != null) ClearMem(response);
        
        request.setAttribute("result", result);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        numberappender = new StringBuilder();
        builder = new StringBuilder();
    }
    
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    private void setZero() {
        if((numberappender.toString().contains(".")) || (numberappender.length()<9)){
                addSymbol("0");
        }
    }

    private void setOne() {
        if((numberappender.toString().contains(".")) || (numberappender.length()<9)){
                addSymbol("1");
        }
    }

    private void setTwo() {
        if((numberappender.toString().contains(".")) || (numberappender.length()<9)){
                addSymbol("2");
        }
    }

    private void setThree() {
        if((numberappender.toString().contains(".")) || (numberappender.length()<9)){
                addSymbol("3");
        }
            
    }

    private void setFour() {
        if((numberappender.toString().contains(".")) || (numberappender.length()<9)){
                addSymbol("4");
        }
    }

    private void setFive() {
        if((numberappender.toString().contains(".")) || (numberappender.length()<9)){
                addSymbol("5");
        }
    }

    private void setSix() {
        if((numberappender.toString().contains(".")) || (numberappender.length()<9)){
                addSymbol("6");
        }
    }

    private void setSeven() {
        if((numberappender.toString().contains(".")) || (numberappender.length()<9)){
                addSymbol("7");
        }
    }

    private void setEight() {
        if((numberappender.toString().contains(".")) || (numberappender.length()<9)){
                addSymbol("8");
        }
    }

    private void setNine() {
        if((numberappender.toString().contains(".")) || (numberappender.length()<9)){
                addSymbol("9");
        }
    }
    private void setPoint() {
        if(!numberappender.toString().contains(".")){
            addSymbol(".");
        }
        
    }
    
    private void setPi(){
        addSymbol(String.format("%.2f", Math.PI));        
    }
    
     private void addSymbol(String symbol) {
        numberappender.append(symbol);
        updateResult();
    }
     
    private void setAddition(){
        builder.append(numberappender.toString()).append("_").append("+").append("_");
         numberappender = new StringBuilder();
    }
    
    private void setSubtraction(){
        builder.append(numberappender.toString()).append("_").append("-").append("_");
         numberappender = new StringBuilder();
    }
    
    private void setMultiplication(){
        builder.append(numberappender.toString()).append("_").append("x").append("_");
        numberappender = new StringBuilder();
    }
    
    private void setDivision(){
        builder.append(numberappender.toString()).append("_").append("/").append("_");
         numberappender = new StringBuilder();
    }
    
    private void setSqrt(){
        builder.append(numberappender.toString());
        numberappender = new StringBuilder();
        updateResult(calculateroot());
    }
    
    private void setEquals(HttpServletResponse response){
        builder.append(numberappender.toString());
        
        Cookie ck = new Cookie("NetweadCalculatorLast",builder.toString());
        response.addCookie(ck);
        
        numberappender = new StringBuilder();
        updateResult(calculate());
    }
    
    private void clear(){
        builder = new StringBuilder();
        numberappender = new StringBuilder();
        updateResult();
    }
    
    private void LastOp(HttpServletRequest request){
        clear();
        Cookie ck[] = request.getCookies();
        for(Cookie cookie : ck){
            if (cookie.getName().equals("NetweadCalculatorLast")){
                builder.append(cookie.getValue());
                updateResult(cookie.getValue().replace("_", " "));
                break;
            }
        }
    }
    
    private void ClearMem(HttpServletResponse response){
        Cookie ck = new Cookie("NetweadCalculatorLast","");
        ck.setMaxAge(0);
        response.addCookie(ck);
    }
    
    
    private void updateResult(){
        if(numberappender.toString().contains(".")){
            if(numberappender.toString().split("\\.").length > 1){
                if(numberappender.toString().split("\\.")[1].length() > 2){
                    String temp = String.format("%.2f", Double.parseDouble(numberappender.toString()));
                    numberappender = new StringBuilder();
                    numberappender.append(temp);
                }
            }
        }
                result = numberappender.toString();
    }
    private void updateResult(String ans){
        result = ans;
    }
    
    private String calculateroot(){
        
        String root = Double.toString(Math.sqrt(Double.parseDouble(builder.toString())));
        builder = new StringBuilder();
        builder.append(root);
        return String.format("%.2f", Double.parseDouble(root));
    }
    
    private String calculate(){
        
        String[] arr = builder.toString().split("_");
        String num1=arr[0];
        System.out.println(arr[0]+" "+arr[2]);
        String num2=arr[2];
        
         for(int i=0;i<arr.length;i++){
      if (i%2!=0){
        if (arr[i].equals("+"))
            num1 = Double.toString(Double.parseDouble(num1)+Double.parseDouble(num2));
        if (arr[i].equals("-"))
            num1=Double.toString(Double.parseDouble(num1)-Double.parseDouble(num2));
        if (arr[i].equals("x"))
            num1=Double.toString(Double.parseDouble(num1)*Double.parseDouble(num2));
        if (arr[i].equals("/"))
            num1=Double.toString(Double.parseDouble(num1)/Double.parseDouble(num2));
        
    if (i%2 == 0 && i != arr.length-1){
        num2=arr[i+2];
     }
        builder = new StringBuilder();
        builder.append(num1);
        
     }
         }
         num1 = String.format("%.2f", Double.parseDouble(num1));
         
         if(num1.split("\\.")[0].length()>9)
             num1 = "E";
         
          return num1;
    }
}
