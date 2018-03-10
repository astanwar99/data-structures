#include<stdio.h>
#define n 5
struct burn
{
    int que[n];
    int front;
    int rear;
}q;

int pd;

int isfull()
{
    if(q.front==(q.rear+1)%n)
    return 1;
    else
    return 0;
}

int isempty()
{
    if(q.front==-1)
        return 1;
    else
        return 0;
}

void enqueue(int data)
{
    if(q.front==-1)
        q.front=q.rear=0;
    else
        q.rear=(q.rear+1)%n;
    q.que[q.rear]=data;
}

int dequeue()
{
    int item;
    item=q.que[q.front];
    if(q.front==q.rear)
        q.front=q.rear=-1;
    else
    q.front=(q.front+1)%n;
    pd=item;
    return item;
}

void display()
{
    if(isempty())
    {
        printf("\nCircular buffer empty!!!");
        return;
    }
    int i;
    i=q.front;
    while(i!=q.rear)
    {
        printf("\n%d",q.que[i]);
        i=(i+1)%n;
    }
    printf("\n%d",q.que[i]);
}

void disp()
{
    printf("\nFront index:%d",q.front);
    printf("\nRear index:%d",q.rear);
}

void newdisp()
{
    printf("\nLast burnt data: %d",pd);
}

int main()
{
    int ch,data;
    q.front=-1;
    q.rear=0;
    printf("\n\tMAIN MENU\n1. Write data onto the circular buffer");
    printf("\n2. Burn data onto the DVD");
    printf("\n3. Display data currently on the circular buffer(Data that has not been burnt yet)");
    printf("\n4. Display last burnt data");
    printf("\n5. Display front and rear indices");
    printf("\n6. Exit");
    do
    {
        printf("\n Enter your choice: ");
        scanf("%d",&ch);
        switch(ch)
        {
            case 1:
                if(isfull())
                    printf("\nCircular Buffer is Full! Please Burn the Data in the DVD");
                else
                {
                    printf("\nEnter data:\n");
                    scanf("%d",&data);
                    enqueue(data);
                }
                break;
            case 2:
                if(isempty())
                    printf("\nCircular Buffer is Empty! Please Enter New Data to Read");
                else
                    printf("\nThe Data Burned on the DVD is %d",dequeue());
                break;
            case 3:
                display();
                break;
            case 4:
                newdisp();
                break;
            case 5:
                disp();
                break;
            case 6:
                printf("\nExiting process!");
                break;
            default:
                printf("\nInvalid choice! Please try again!");
        }
    }while(ch!=6);
    return 0;
}
