/*
Ashwani Singh Tanwar
17BIT0231
Created on: 17-01-2018

Question 8.
a) There is a garage where the access road can accommodate any number of trucks
at one time. The garage is built in such a way that only the last truck entered
can be moved out. Each of the trucks is identified by a positive integer (a truck_id).
Implement dynamically to handle truck moves, allowing for the following commands:

i) On_road (truck_id); ii) Enter_garage (truck_ id);
iii) Exit_garage (truck_id); iv) Show_trucks (garage or road);
If an attempt is made to get a truck out which is not the closest to the garage
entry, the error message “ Truck x cannot be moved ” should be displayed.

b) For the aforementioned scenario, assume now a circular road and two entries:
one for entry, another for exit. Trucks can get out only in the order they got in.
Write a program dynamically to handle truck moves allowing for the following commands
  i) Enter garage (truck name)
  ii) Exit garage (truck name)
  iii) Show trucks

Low Level: Implement the above problem.	                                            [6 marks]

Middle Level: Also check the number of services done so far to decide if service
charge is required or not.                                                              [2 marks]

High Level:Assuming any nth truck will need a longer period of time for service,
that particular truck should be retained in the garage and the links in the stack
should be modified accordingly.				                                            [2 marks]
*/

#include<iostream>
using namespace std;
#define gmax 5


int service[2][50];
static int counter=0;
/*
Structure declaration for garage.
*/
struct Garage
{
    int gar[gmax];
    int top;
}garage;
/*
Structure declaration for service lane.
*/
struct node
{
    int truck_id;
    struct node *next;
}*start;

/*
Push function to insert data in the linked list.
*/
void On_road(int ele)
{
    int i;
    struct node *temp,*t;
    temp=new(struct node);
    temp->next=NULL;
    temp->truck_id=ele;

    if(start==NULL)
    {
        start=temp;
    }
    else
    {
        t = start;
        while(t -> next != NULL)
        {
            t = t -> next;
        }
        t -> next = temp;
        //start = temp;
        //start -> next = t;
    }
}

/*
Push function to insert truck into garage
*/
void Enter_garage(int ele)
{
    struct node *temp;
    temp = start;
    int flag,i;
    /*
    while((temp -> next) -> next != NULL)
    {
        temp = temp -> next;
    }
    */
    if (garage.top != gmax-1 && ele == start -> truck_id)
    {
        garage.gar[++garage.top] = ele;
        start = start -> next;
        delete(temp);
        flag = 0;
        for(i = 0; i<counter; i++)
        {
            if(service[0][i] == ele)
            {
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            service[1][i]++;
        else
        {
            service[0][counter++]=ele;
            service[1][i]=1;
        }
        cout<<"\nService No.: "<<service[1][i];
        if (service[1][i] >= 3)
            cout<<"\nService charge required.";
    }
    else
        cout<<"\nEither garage is full or this truck cannot enter garage yet.\n"
            <<"\nWhat you can try:"
            <<"\n1.Try clearing space in the garage first."
            <<"\n2.Move other trucks first which are ahead of this truck in line.";
}

/*
Pop function to delete data from garage.
*/
void Exit_garage(int ele)
{
    if (garage.gar[garage.top] != ele)
    cout<<"\nTruck with ID "<<ele<<" is not in the garage or cannot be moved out yet.";
    else
    {
        cout<<"\nTruck with ID "<<ele<<" moved out.\n";
        garage.top--;
    }
}

/*
Display function to display the stack content.
*/
void Show_trucks()
{
    int i;
    struct node *temp;
    temp=start;
    cout<<"\nTrucks on road:\n";
    while(temp != NULL)
    {
        cout<<temp->truck_id<<"\n";
        temp = temp -> next;
    }

    if(garage.top == -1)
        cout<<"\nGarage is vacant.";
    else
    {
        cout<<"\nTrucks in garage:\n";
        for(i=0;i<=garage.top;i++)
            cout<<garage.gar[i]<<"\n";
    }
}


int main()
{
    int i,n,ch,truck_id;
    garage.top=-1;

    cout<<"\n==============================="
        <<"\nEnter a choice\n"
        <<"1.New truck entry(On service road).\n"
        <<"2.Enter garage.\n"
        <<"3.Exit garage.\n"
        <<"4.Display all trucks.\n"
        <<"5.Exit\n"
        <<"===============================\n";
    do
    {
        cout<<"\nChoice: ";
        cin>>ch;
        struct node *temp;
        int flag, i;

        switch(ch)
        {
            case 1: cout<<"\nEnter truck id:\n";
                    cin>>truck_id;
                    flag = 0;
                    temp = start;
                    while(temp != NULL)
                    {
                        if (temp -> truck_id == truck_id)
                        {
                            flag = 1;
                            break;
                        }
                        temp = temp -> next;
                    }
                    for (i = 0; i <= garage.top; i++)
                    {
                        if (garage.gar[i] ==  truck_id)
                        {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 1)
                        cout<<"\nThis truck is already in the service lane or garage.";
                    else
                        On_road(truck_id);
                    break;
            case 2: cout<<"\nEnter truck id for moving it to garage:\n";
                    cin>>truck_id;
                    Enter_garage(truck_id);
                    break;
            case 3: cout<<"\nEnter truck id for moving it out of the garage:\n";
                    cin>>truck_id;
                    Exit_garage(truck_id);
                    break;
            case 4: Show_trucks();
                    break;
            case 5: break;
            default:cout<<"\nWrong choice\n";
                    break;

        }
    }while(ch!=5);
    return 0;

}
