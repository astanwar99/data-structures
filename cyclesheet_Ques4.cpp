/*
Ashwani Singh Tanwar
17BIT0231
Created on: 12-01-2018

Question 4:
Design a program to employ a stack for balancing symbols such as
parentheses, flower braces and square brackets, in the code snippet
given below.

for(i=0;i<n;i++)
{
if(i<5)
{  z[i]=x[i]+y[i];
       p=(((a+b)*c)+(d/(e+f)*g);
}

Ensure that your program works for any arbitrary expression.

Low Level:  Implement balancing of parenthesis only                             [6 marks]

Middle Level: Implement balancing of all symbols only for some specified
expressions only                                                                [2 Marks]

High Level: Implement for any arbitrary expression given by faculty             [2 marks]
*/

#include<iostream>
#include<string>

using namespace std;

int main()
{
    int i,j;
    string expression="",word="";
    char ch;
    //Initializing variables to store number of opening and closing brackets of each type
    /*
    poc->parenthesis opening counter
    pcc->parenthesis closing counter
    foc->flower opening counter
    fcc->flower closing counter
    soc->square opening counter
    scc->square closing counter
    */
    int poc=0,pcc=0,foc=0,fcc=0,soc=0,scc=0;
    cout<<"Enter the code snippet: "
        <<"(Type 'END' to stop giving the input)\n";

    //Taking input.
    while(word!="END")
    {
        expression.append(word);
        expression.append("\n");
        getline(cin,word);
    }

    //For counting total opening and closing brackets for each type.
    for(i=0;i<expression.length();i++)
    {
        ch=expression[i];
        switch(ch)
        {
            case '{':
                foc++;
                break;
            case '}':
                fcc++;
                break;
            case '(':
                poc++;
                break;
            case ')':
                pcc++;
                break;
            case '[':
                soc++;
                break;
            case ']':
                scc++;
                break;
        }
    }


    //Checking and balancing brackets

    //1.Parenthesis
    if(poc==pcc)
    {
        cout<<"\nParenthesis are balanced.";
    }
    else
    {
        if(poc>pcc)
            for(j=0;j<poc-pcc;j++)
                expression.append(")");
        else
        cout<<"\nOpening parenthesis brackets could not be balanced.";
    }
    //2.Square brackets
    if(soc==scc)
    {
        cout<<"\nSquare brackets are balanced.";
    }
    else
    {
        if(soc>scc)
            for(j=0;j<soc-scc;j++)
                expression.append("]");
        else
        cout<<"\nOpening square brackets could not be balanced.";
    }
    //3.Flower brackets
    if(foc==fcc)
    {
        cout<<"\nFlower brackets are balanced.";
    }
    else
    {
        if(foc>fcc)
            for(j=0;j<foc-fcc;j++)
                expression.append("\n}");
        else
        cout<<"\nOpening flower brackets could not be balanced.";
    }

    //Output
    cout<<"\nExpression with balanced brackets:\n"<<expression;
    return 0;
}
