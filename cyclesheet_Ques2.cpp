/*
Ashwani Singh Tanwar
17BIT0231
Created on: 20-12-2017

Question 2:
To facilitate a thorough net surfing, any web browser has back and forward
buttons that allow the user to move backward and forward through a series
of web pages. To allow the user to move both forward and backward two stacks
are employed. When the user presses the back button, the link to the current
web page is stored on a separate stack for the forward button. As the user
moves backward through a series of previous pages, the link to each page is
moved in turn from the back to the forward stack.

When the user presses the forward button, the action is the reverse of the
back button. Now the item from the forward stack is popped, and becomes the
current web page. The previous web page is pushed on the back stack. Simulate
the functioning of these buttons using array implementation of Stack.
Also provide options for displaying the contents of both the stacks whenever required.

Low Level:Implement either forward stack or backward stack              [6 Marks]

Middle Level: Implement web browser navigation using both the stacks    [2 Marks]

High Level: Use a single array to implement both the stacks             [2 Marks]

*/

#include<iostream>
#include<string>
using namespace std;

struct stack
{
    string b[20];
    string f[20];
    int back,forward;
}st;

void b_push()
{
    if (st.back==19)
    cout<<"\nStack overflow";
    else
    {
        st.b[++st.back]=st.f[st.forward];
    }
}

void b_push_new()
{

    cout<<"\nEnter website URL:";
    cin>>st.b[++st.back];

}

void f_push()
{
    st.f[++st.forward]=st.b[st.back];
}

void b_pop()
{
    st.back--;
}

void f_pop()
{
    st.forward--;
}

void display()
{
    cout<<"\nCurrent website:"<<st.b[st.back]<<"\n";
    cout<<"\nback->"<<st.b[st.back-1]<<"\n";
    for(int i=st.back-2;i>=0;i--)
    {
        cout<<"      "<<st.b[i]<<"\n";
    }
    cout<<"\nforward->"<<st.f[st.forward]<<"\n";
    for(int i=st.forward-1;i>=0;i--)
    {
        cout<<"         "<<st.f[i]<<"\n";
    }
}

int main()
{
    int i,n,ch;
    st.back=-1;
    st.forward=-1;

    cout<<"\n===========================\n"
        <<"Enter a choice\n"
        <<"1.Browse new website\n"
        <<"2.Back\n"
        <<"3.Forward\n"
        <<"4.Display status\n"
        <<"5.Exit\n"
        <<"===========================\n";

    do
    {
        cout<<"\nChoice: ";
        cin>>ch;

        switch(ch)
        {
            case 1: b_push_new();
                    break;
            case 2:
                    if(st.back==0)
                    cout<<"\nNO RECORD AVAILABLE\n";
                    else
                    {
                        f_push();
                        b_pop();
                    }
                    break;
            case 3:
                    if(st.forward==-1)
                    cout<<"\nNO RECORD AVAILABLE\n";
                    else
                    {
                        b_push();
                        f_pop();
                    }
                    break;
            case 4: display();
                    break;
            case 5: break;
            default:cout<<"\nWrong choice\n";
                    break;

        }
    }while(ch!=5);
    return 0;

}
