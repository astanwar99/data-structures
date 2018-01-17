#include<stdio.h>
struct queue
{
    int a[20];
    int front,rear;
} rc;

int queue_full()
{
    if (rc.rear==19)
    {
        printf("\nRide is full. Ready to start!");
        //queue_disp();
        return 1;
    }
    else
    return 0;
}

int queue_insertion()
{
    int num;
    if ((queue_full())==1)
    {
        rc.front=-1;
        rc.rear=-1;
    }
    else if(rc.rear==-1)
    {
        rc.rear++;
        rc.front++;
        printf("\nEnter member number:Adults(>100) Children(<100)");
        scanf("%d",&num);
        rc.a[rc.rear]=num;
        if
    }
    else
    {
        printf("\nEnter member number:");
        scanf("%d",&num);
        rc.a[++rc.rear]=num;
    }
    return num;
}


int main()
{
    int ch,n,cd=0,ad=0;
    rc.rear=-1;
    rc.front=-1;
    printf("\nWelcome!");
    do
    {
        printf("\nEnter 1 if there are people waiting for a ride:");
        printf("\nEnter 2 if there are no more people waiting:");
        scanf("%d",&ch);
        if(ch==1)
        {
            n=queue_insertion();
            if (n>100)
            ad++;
            else
            cd++;
        }
        else if(ch==2)
        printf("\nThank You for coming!");
    }while(ch==1 && ch!=2);
    printf("\nTotal Adults:%d\nTotal children:%d",ad,cd);
    return 0;
}


