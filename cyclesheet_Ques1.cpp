/*
Ashwani Singh Tanwar
17BIT0231
Created on: 14-12-2017

Question 1:
Students of a Programming class arrive to submit assignments. Their register
numbers are stored in a LIFO list in the order in which the assignments are
submitted. Write a program using array to display the register number of the
ten students who submitted first.

Register number of the ten students who submitted first will be at the bottom
of the LIFO list. Hence pop out the required number of elements from the top
so as to retrieve and display the first 10 students.

Low Level: Display the register number of the last submitted record                [6 Marks]

Middle Level: Display the register number of the ten students who submitted
first                                                                              [2 Marks]

High Level: Should implement low level and middle level modules + any query
posed by faculty such as checking if a particular student has submitted the
assignment or not                                                                  [2 Marks]

*/

#include<iostream>
using namespace std;

/*
Structure declaration.
*/
struct stack
{
    int x[20];
    int top;
}st;

/*
Push function to insert data.
*/
void push()
{
    int ele;
    if (st.top==19)
    cout<<"\nStack overflow";
    else
    {
        cout<<"\nEnter the register number:";
        cin>>ele;
        st.x[++st.top]=ele;
    }
}

/*
Pop function to delete data.
*/
void pop()
{
    if(st.top==-1)
    cout<<"\nStack underflow";
    else
    {
        cout<<"\nDeleted item: "<<st.x[st.top];
        st.top--;
    }
    cout<<"\n";
}

/*
Display function to display the stack content.
*/
void display()
{
    cout<<"\ntop->"<<st.x[st.top]<<"\n";
    for(int i=st.top-1;i>=0;i--)
    {
        cout<<"     "<<st.x[i]<<"\n";
    }
}

/*
Function to remove extra copies from stack.
*/
void high_level()
{
    cout<<"\nRemoving redundant copies of register numbers\n";
    for (int i=0;i<=st.top;i++)
    {
        for (int j=i+1;j<=st.top;j++)
        {
            if(st.x[j]==st.x[i])
            {
                for(int k=j;k<st.top;k++)
                {
                    st.x[k]=st.x[k+1];
                }
                st.top--;
            }
        }
    }
    cout<<"Successful!!!";
    display();
}

int main()
{
    int i,n,ch;
    st.top=-1;

    cout<<"\n==============================="
        <<"\nEnter a choice\n"
        <<"1.Enter register number\n"
        <<"2.Delete register number\n"
        <<"3.Display Stack\n"
        <<"4.Register number of the last submitted record\n"
        <<"5.Register number of the ten students who submitted first\n"
        <<"6.High level(Removing extra copies of register numbers from stack)\n"
        <<"7.Exit\n"
        <<"===============================\n";
    do
    {
        cout<<"\nChoice: ";
        cin>>ch;

        switch(ch)
        {
            case 1: cout<<"\nEnter the number of register numbers:\n";
                    cin>>n;
                    for(i=0;i<n;i++)
                        push();
                    break;
            case 2: cout<<"\nEnter the number of register numbers you wish to delete:\n";
                    cin>>n;
                    for(i=0;i<n;i++)
                        pop();
                    break;
            case 3: display();
                    break;
            case 4: cout<<"\nRegister number of the last submitted record: "
                        <<st.x[st.top];
                    break;
            case 5: if(st.top>=10)
                    {
                        cout<<"\nRegister number of the ten students who submitted first:\n";
                        for(i=0;i<10;i++)
                            cout<<i+1<<". "<<st.x[i]<<"\n";
                    }
                    else
                    {
                        cout<<"\nOnly "<<st.top+1<<" students have submitted their assignments.\n"
                            <<"Use 'Display Stack' option to see the register numbers\n";
                    }
                    break;
            case 6: high_level();
                    break;
            case 7: break;
            default:cout<<"\nWrong choice\n";
                    break;

        }
    }while(ch!=7);
    return 0;

}
