/*
Ashwani Singh Tanwar
17BIT0231
Created on: 12-01-2018

Question 5:
Some priests are given three poles and a stack of 4 gold disks, each disk a
little smaller than the one beneath it. Their assignment is to transfer all
4 disks from one of the 3 pole to another with 2 important constraints. They
can move only one disk at a time, and they can never place a larger disk on
top of a smaller one.  Design a recursive program for the above Towers of Hanoi
puzzle using stack.

Low Level: Implement the problem using recursion.                                          [6 marks]

Middle Level: Implement the problem using recursion and also trace the flow
of execution.                                                                              [2 marks]

High Level: Implement without recursion at least for few disks.                            [2 marks]

*/
#include<iostream>
#include<string>
#define size 20
using namespace std;

struct tower
{
	int s[size];
	int top;
}from,aux,to;

int pop(struct tower *x)
{
    int z=x->s[x->top];
    x->top--;
    return z;
}

/*
Display function to display the stack content.
*/
void display()
{
    static int tot=0;
    cout<<"Step: "<<tot<<"\n";
    cout<<"=====================\n";
    cout<<"\nfrom->"<<from.s[from.top]<<"\n";
    for(int i=from.top-1;i>=0;i--)
    {
        cout<<"      "<<from.s[i]<<"\n";
    }
    cout<<"\nto->"<<to.s[to.top]<<"\n";
    for(int i=to.top-1;i>=0;i--)
    {
        cout<<"    "<<to.s[i]<<"\n";
    }
    cout<<"\naux->"<<aux.s[aux.top]<<"\n";
    for(int i=aux.top-1;i>=0;i--)
    {
        cout<<"     "<<aux.s[i]<<"\n";
    }
    cout<<"=====================\n";
    tot++;
}

void Hanoi(int n,struct tower *fr,struct tower *au,struct tower *t)
{
    int x;
    if (n==1)
    {
        x=pop(fr);
        t->s[++t->top]=x;
        display();
    }
    else
    {
        Hanoi(n-1,fr,t,au);
        Hanoi(1,fr,au,t);
        Hanoi(n-1,au,fr,t);
    }
}

int main()
{

    int num,x;
    from.top=-1;
    to.top=-1;
    aux.top=-1;
    cout<<"Enter number of discs: ";
    cin>>num;
    cout<<"\n\n";
    for(from.top=0;from.top<num;from.top++)
        from.s[from.top]=num-from.top;
    from.top--;
    cout<<"INITIAL STAGE:\n";
    display();
    Hanoi(num,&from,&aux,&to);
    return 0;
}
