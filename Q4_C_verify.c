/*
SHIVAM  PAUL
17BIT0328

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
High Level: Implement for any arbitrary expression given by faculty
           [2 marks]
*/

#include<stdio.h>
#include<string.h>

int count=0;
void main()
{
    int i,j;
    char expression[50]="";
    char ch;
    char c;
  /*po->parenthesis opening counter
    pc->parenthesis closing counter
    fo->flower opening counter
    fc->flower closing counter
    so->square opening counter
    sc->square closing counter
    */
    int po=0,pc=0,fo=0,fc=0,so=0,sc=0;
    printf("\nEnter the code: ");
    printf("\nType '@' to stop\n");
    while(c!='@')
    {
        strcat(expression,c);
        strcat(expression,"\n");
        scanf("%c",&c);
        count++;
    }
    for(i=0;i<count;i++)
    {
        ch=expression[i];
        switch(ch)
        {
            case '{': fo++; break;
            case '}': fc++; break;
            case '(': po++; break;
            case ')': pc++; break;
            case '[': so++; break;
            case ']': sc++; break;
        }
    }
    if(po==pc)
    {
        printf("\nParenthesis balanced.");
    }
    else
    {
        if(po>pc)
            for(j=0;j<po-pc;j++)
                strcat(expression,")");
        else
        printf("\nOpening parenthesis brackets not balanced.");
    }
    if(so==sc)
    {
        printf("\nSquare brackets balanced.");
    }
    else
    {
        if(so>sc)
            for(j=0;j<so-sc;j++)
                strcat(expression,"]");
        else
        printf("\nOpening square brackets not balanced.");
    }
    if(fo==fc)
    {
        printf("\nFlower brackets balanced.");
    }
    else
    {
        if(fo>fc)
            for(j=0;j<fo-fc;j++)
                strcat(expression,"\n}");
        else
        printf("\nOpening flower brackets not balanced.");
    }
    printf("\nExpression with balanced brackets:\n%s",expression);
}
