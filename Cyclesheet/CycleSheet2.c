#include<stdio.h>
struct stack
{
        int top_b;
        int b[30];
}bck;

struct stack1
{
        int top_f;
        int f[30];
}fwd;

void bak()
{
    int item;
    if (bck.top_b==-1)
        printf("\nEnd of history!");
    else
    {
        item=bck.b[bck.top_b];
        bck.top_b--;
        fwd.f[++fwd.top_f]=item;
    }
}

void fwrd()
{
    int item;
    if(fwd.top==49)
        printf("\nYou have reached the last page!");
    else
    {
        item=fwd.f[fwd.top_f];
        fwd.top_f--;
        bck.b[++bck.top_b]=item;
    }
}

int main()
{
    int ch;
    do
    {
        printf("\nEnter operation:");
        printf("\n1. Go back\n2. Go forward\n3. Exit operation");
        scanf("%d",&ch);
        switch(ch)
        {
            case 1: bak(); break;
            case 2: fwrd(); break;
            case 3: break;
            default: printf("\nInvalid choice! Please try again:");
        }
    }while(ch!=3);

}
