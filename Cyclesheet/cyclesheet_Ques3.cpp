/*
Ashwani Singh Tanwar
17BIT0231
Created on: 10-01-2018

QUESTION-3:
3. Most of the bugs in scientific and engineering applications are due to
improper usage of precedence order in arithmetic expressions.  Thus it is
necessary to use an appropriate notation that would evaluate the expression
without taking into account the precedence order and parenthesis.

a) Write a program to convert the given arithmetic expression into
i) Reverse Polish notation (Post-fix).
ii) Polish notation (Pre-fix).

b) Evaluate the above notations with necessary input.

Low Level:  Implement one conversion and its evaluation 	            [6 marks]
Middle Level: Implement both polish and reverse polish conversions      [2 marks]
High Level:  Implement both a and b                                     [2 marks]
*/

#include<iostream>
#include<string>
#define size 20
using namespace std;

char infix[20],postfix[20],prefix[20];

struct stack
{
	int s[size];
	int top;
}st;


void push(int ele)
{
	st.top++;
	st.s[st.top]=ele;
}

char pop()
{
	int el;
	char e;
	el=st.s[st.top];
	st.top--;
	switch(el)
	{
		case 1:e='+';
				break;
		case 2:e='-';
				break;
		case 3:e='*';
				break;
		case 4:e='/';
				break;
		case 5:e='^';
				break;
	}
	return(e);
}



void post()
{
	int i,j=0;
	for(i=0;infix[i]!='\0';i++)
	{
		switch(infix[i])
		{
			case '+':
				{
					while(st.s[st.top]>=1)
						postfix[j++]=pop();
					push(1);
					break;
				}
			case '-':
				{
					while(st.s[st.top]>=1)
						postfix[j++]=pop();
					push(2);
					break;
				}
			case '*':
				{
					while(st.s[st.top]>=3)
						postfix[j++]=pop();
					push(3);
					break;
				}
			case '/':
				{
					while(st.s[st.top]>=3)
						postfix[j++]=pop();
					push(4);
					break;
				}
			case '^':
				{
					while(st.s[st.top]>=5)
						postfix[j++]=pop();
					push(5);
					break;
				}
			case '(':
				{
					push(0);
					break;
				}
			case ')':
				{
					while(st.s[st.top]!=0)
						postfix[j++]=pop();
					st.top--;
					break;
				}
			default :postfix[j++]=infix[i];
		}
	}
	while(st.top>0)
	postfix[j++]=pop();
	cout<<"\nThe postfix expression is: ";
	cout<<postfix;
}


void pre()
{
	int i,k,counter=0;
	for(k=0;postfix[k]!='\0';k++)
        counter++;
    cout<<"\nThe prefix expression is: ";
	for(i=counter;i>=0;i--)
	{
        cout<<postfix[i];
	}
}

void evaluate(int val)
{
	st.top=0;

	if (val==1)
	{
	    cout<<"\nEnter the expression: ";
        cin>>infix;
		cout<<"\nEvaluating using Reverse Polish notation:\n";
		post();
	}
	else if (val==2)
	{
		cout<<"\nBoth conversions implemented. Choose option 3 to perform evaluation using them.\n";
	}
	else
    {
        cout<<"\nEnter the expression: ";
        cin>>infix;
        cout<<"\nEvaluating using Reverse Polish notation\n";
		post();
		cout<<"\n\nEvaluating using Polish notation:\n";
		pre();
    }
}

int main()
{
	int choice;
	cout<<"=========================================================================================/n"
        <<"Select your choice:\n"
        <<"1.Implement Reverse Polish notation and its evaluation (LOW LEVEL)\n"
        <<"2.Implement both polish and reverse polish conversions (MIDDLE LEVEL)\n"
        <<"3.Implement both polish and reverse polish conversions and their evaluation (HIGH LEVEL)\n"
        <<"4.Exit\n"
        <<"=========================================================================================/n";
	do
	{
	    cout<<"\nChoice: ";
		cin>>choice;
		switch(choice)
		{
			case 1: evaluate(1);
					break;
			case 2: evaluate(2);
					break;
			case 3: evaluate(3);
					break;
			case 4: cout<<"Exiting...\n";
					break;
			default:cout<<"Wrong choice\n";
					break;

		}
	}while(choice!=4);
	return 0;
}


