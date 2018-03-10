/*
Ashwani Singh Tanwar
17BIT0231
Created on: 2-03-2018

11. Assume FLAMES game that tests for relationship has to be implemented using a dynamic
structure. The letters in the FLAMES stand for Friends, Love, Affection, Marriage, Enmity
and Sister. Initially store the individual letters of the word ‘flames’ in the nodes of
the dynamic structure. Given the count of the number of uncommon letters in the two names
‘n’, write a program to delete every nth node in it, till it is left with a single node.
If the end of the dynamic structure is reached while counting, resume the counting from
the beginning. Display the letter that still remains and the corresponding relationship

Eg., If Ajay and Jack are the two names, there are 4 uncommon letters in these. So delete
4th node in the first iteration and for the next iteration start counting from the node
following the deleted node.

Low Level: Delete only the first nth letter only                                            [6 marks]

Middle Level: Implement the above problem		                                            [2 marks]

High Level: For the same problem instead of deleting the nth letter, make the nth letter as
the last node. Hence at last the first node gives the relationship			                [2 marks]
*/

#include<iostream>
using namespace std;

/*
Node structure.
*/
struct node
{
    char ch;
    struct node *next;
}*start,*hstart;

/*
Insert function to insert FLAMES in the linked list.
*/
void enter_node(char ele)
{
    int i;
    struct node *temp,*t;
    temp=new(struct node);
    temp->next=NULL;
    temp->ch=ele;

    if(start == NULL)
    {
        start=temp;
        temp -> next = start;
    }
    else
    {
        t = start;
        while(t -> next != start)
        {
            t = t -> next;
        }
        t -> next = temp;
        temp -> next = start;
    }
}

/*
This function eliminates nodes from the linked list until a single node remains,
which is the result.
This function is used to meet Low and Medium level objectives of the question.
*/
char get_result(int num)
{
    struct node *temp, *t;
    temp = start;
    for(int j=0; j<5; j++)
    {
        for(int i = 0; i < num - 2; i++)
        {
            temp = temp -> next;
        }
        if (temp -> next == start)
            start = start -> next;
        t = temp -> next;
        temp -> next = t -> next;
        temp = temp -> next;
    }
    return (start -> ch);
}

/*
This function meets the high level objective of the question.
*/
char highlevel(int num)
{
    struct node *temp, *t, *t2;
    char res;
    hstart = NULL;
    temp = start;
    for(int j=0; j<5; j++)
    {
        for(int i = 0; i < num - 2; i++)
        {
            temp = temp -> next;
        }
        if (temp -> next == start)
            start = start -> next;
        t = temp -> next;
        temp -> next = t -> next;
        temp = temp -> next;
        t->next = NULL;
        if(hstart == NULL)
        {
            hstart = t;
        }
        else
        {
            t2 = hstart;
            hstart = t;
            t -> next = t2;
        }
    }
    t2 = hstart;
    hstart = start;
    start -> next = t2;
    struct node *temp2;
    temp2 = hstart;
    cout<<"\nUpdated linked list:\n";
    while(temp2 -> next != NULL)
    {
        cout<<temp2->ch<<"\n";
        temp2 = temp2 -> next;
    }
    cout<<temp2 -> ch<<"\n";
    res = hstart -> ch;
    return (res);
}

//Driver function.
int main()
{
    int num;
    int ch;
    char res, ans;

        do
        {
            cout<<"--------------------------\n"
                <<"1.Low/Medium level\n"
                <<"2.High Level\n"
                <<"3.Exit\n"
                <<"--------------------------\n";
            cin>>ch;
            //Initializing linked list.
            start = NULL;
            enter_node('F');
            enter_node('L');
            enter_node('A');
            enter_node('M');
            enter_node('E');
            enter_node('S');
            switch(ch)
            {
                case 1:
                    cout<<"Enter the number of uncommon letters: ";
                    cin>>num;
                    res = get_result(num);
                    break;
                case 2:
                    cout<<"Enter the number of uncommon letters: ";
                    cin>>num;

                    res = highlevel(num);
                    break;
                case 3:
                    break;
                default :
                    cout<<"/nWrong choice. Try again.";
                    break;
            }
            if (ch == 1 || ch == 2)
            {
                cout<<"Result : ";
                switch (res)
                {
                    case 'F':cout<<"F -> Friends\n";
                                break;
                    case 'L':cout<<"L -> Love\n";
                                break;
                    case 'A':cout<<"A -> Affection\n";
                                break;
                    case 'M':cout<<"M -> Marriage\n";
                                break;
                    case 'E':cout<<"E -> Enmity\n";
                                break;
                    case 'S':cout<<"S -> Sister\n";
                                break;
                }
            }
        }while(ch != 3);
    return 0;

}
