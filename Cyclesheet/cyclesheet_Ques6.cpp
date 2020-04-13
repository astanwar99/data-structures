/*
Ashwani Singh Tanwar
17BIT0231
Created on: 17-01-2018

QUESTION-6:
In a theme park, the Roller-Coaster ride is started only when a good number
of riders line up in the counter (say 20 members). When the ride proceeds with
these 20 members, a new set of riders will line up in the counter. This keeps
continuing. Implement the above scenario of lining up and processing using arrays
with Queue ADT.

Low Level: Implement the aforementioned problem                                         [6 Marks]

Middle Level: Also count the number of adults and children                              [2 Marks]

High Level: If a VIP family arrives, process them  before processing others who
are already waiting in the queue                                                        [2 marks]
*/


#include<iostream>
using namespace std;

//QUEUE structure
struct queue
{
    int age[30],reg[30];
    char v_stat[30];
    int child,adult;
    int front,rear;
}lq;

//Function for pushing elements into queue and receive other data
//Also to calculate number of children and adults
void push()
{
    void ride();
    int item,regn;
    char ch;

    cout<<"\nEnter registration number: ";
    cin>>regn;
    cout<<"\nEnter the age of person: ";
    cin>>item;
    cout<<"\nVIP?(y/n): ";
    cin>>ch;

    if (lq.rear==29)
    {
        cout<<"\nQueue overflow";
        ride();
    }
    else if(lq.rear!=-1)
    {
        lq.age[++lq.rear]=item;
        lq.reg[lq.rear]=regn;
        if(item>12)
            lq.adult++;
        else
            lq.child++;
        lq.v_stat[lq.rear]=ch;
    }
    else
    {
        lq.age[++lq.rear]=item;
        if(item>12)
            lq.adult++;
        else
            lq.child++;
        lq.front++;
        lq.v_stat[lq.rear]=ch;
        lq.reg[lq.rear]=regn;
    }
}

//Function for displaying the Queue elements
void display()
{
    cout<<"\nQueue elements:\n";
    for (int i=lq.front;i<=lq.rear;i++)
    {
        cout<<lq.reg[i]<<"\t"<<lq.age[i]<<"\t"<<lq.v_stat[i]<<"\n";
    }
}

//Pop function.
void pop()
{
    if (lq.front==lq.rear)
    {
        cout<<"\nAge of removed person: "<<lq.age[lq.rear];
        lq.front=-1;
        lq.rear=-1;
    }
    else if(lq.rear==-1)
    {
        cout<<"\nQueue empty";
    }
    else
    {
        cout<<"\nAge of removed person: "<<lq.age[lq.front];
        lq.front++;
    }
}

//Function to provide final queue for ride.
//Also displays the number of children and adults in the queue.
void ride()
{
    int rfr[20],j,i,k=0;
    for(j=0;j<=lq.rear-lq.front;j++)
    {
        for (i=lq.front;i<=lq.rear;i++)
        {
            if(lq.v_stat[i]=='y')
            {
                rfr[j]=lq.reg[i];
                lq.v_stat[i]='d';
                k++;
                break;
            }
        }
    }
    for(j=k;j<=lq.rear-lq.front;j++)
    {
        for (i=lq.front;i<=lq.rear;i++)
        {
            if(lq.v_stat[i]!='d')
            {
                rfr[j]=lq.reg[i];
                lq.v_stat[i]='d';
                break;
            }
        }
    }
    cout<<"\nPlease enter the ride in given sequence:\n";
    for(j=0;j<=lq.rear-lq.front;j++)
        cout<<j+1<<". "<<rfr[j]<<"\n";

    cout<<"\nNumber of Adults: "<<lq.adult
        <<"\nNumber of children: "<<lq.child;
    lq.front=-1;
    lq.rear=-1;

}


//Driver function for the program
//Menu-driven function.
int main()
{
    lq.child=0;
    lq.adult=0;
    int ch,i,k;
    lq.rear=-1;
    lq.front=-1;
    cout<<"==========================="
        <<"\nEnter your choice:"
        <<"\n1.Enter persons"
        <<"\n2.Remove persons"
        <<"\n3.Display queue"
        <<"\n4.READY FOR RIDE."
        <<"\n5.Exit."
        <<"\n===========================\n";
    do
    {
        cout<<"Choice: ";
        cin>>ch;
        switch(ch)
        {
            case 1: cout<<"\nHow many persons you want to enter?:";
                    cin>>k;
                    for(i=0;i<k;i++)
                        push();
                    break;
            case 2: cout<<"\nHow many persons you want to remove?:";
                    cin>>k;
                    for(i=0;i<k;i++)
                        pop();
                    break;
            case 3: display();
                    break;
            case 4: if(lq.rear-lq.front>=5)
                        ride();
                    else
                        cout<<"Not sufficient people for ride to start.";
                    break;
            case 5: break;
            default:cout<<"\nWrong choice";
                    break;
        }
    }while(ch!=5);


    return 0;
}
