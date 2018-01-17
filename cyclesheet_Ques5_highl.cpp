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
#include<math.h>
#define size 20
using namespace std;

struct tower
{
	int s[size];
	int top;
}from,aux,to;

int pop(struct tower *x)
{
    if (x->top!=-1)
    {
        int z=x->s[x->top];
        x->top--;
        return z;
    }
    else
        return -1;

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

// Function to implement legal movement between
// two poles
void moveDisksBetweenTwoPoles(struct tower *fr,struct tower *t)
{
    int pole1TopDisk = pop(fr);
    int pole2TopDisk = pop(t);

    // When pole 1 is empty
    if (pole1TopDisk == -1)
    {
        fr->s[++fr->top]= pole2TopDisk;
    }

    // When pole2 pole is empty
    else if (pole2TopDisk == -1)
    {
        t->s[++t->top]=pole1TopDisk;
    }

    // When top disk of pole1 > top disk of pole2
    else if (pole1TopDisk > pole2TopDisk)
    {
        fr->s[++fr->top]=pole1TopDisk;
        fr->s[++fr->top]=pole2TopDisk;
    }

    // When top disk of pole1 < top disk of pole2
    else
    {
        t->s[++t->top]=pole2TopDisk;
        t->s[++t->top]=pole1TopDisk;
    }
}

void Hanoi(int n,struct tower *fr,struct tower *au,struct tower *t)
{
    int i;
    for (i = 1; i <=pow(2,n)-1; i++)
    {
        if (i % 3 == 1)
          moveDisksBetweenTwoPoles(fr, t);

        else if (i % 3 == 2)
          moveDisksBetweenTwoPoles(fr,au);

        else if (i % 3 == 0)
          moveDisksBetweenTwoPoles(au,t);

        display();
    }

}

int main()
{

    int num,x;
    from.top=-1;
    to.top=-1;
    aux.top=-1;
    cout<<"Enter number of disks: ";
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
