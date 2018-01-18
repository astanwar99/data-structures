#include<stdio.h>

struct stack
{
    int single[40];
    int back,forward;
}st;

void b_push_new()
{

    printf("\nEnter website URL:");
    scanf("%d",st.single[++st.back]);

}

void b_push()
{
    if (st.back==19)
    printf("\nStack overflow");
    else
    {
        st.single[++st.back]=st.single[st.forward];
    }
}


void f_push()
{
    st.single[--st.forward]=st.single[st.back];
}

void b_pop()
{
    st.back--;
}

void f_pop()
{
    st.forward++;
}

void display()
{
    int i;
    printf("\nCurrent website:%d\n",st.single[st.back]);
    printf("\nback->%d\n",st.single[st.back-1]);
    for(i=(st.back-2);i>=0;i--)
    {
        printf("      %d\n",st.single[i]);
    }
    printf("\nforward->%d\n",st.single[st.forward]);
    for(i=(st.forward+1);i<40;i++)
    {
        printf("         %d\n",st.single[i]);
    }
}

void main()
{
    int i,n,ch;
    st.back=-1;
    st.forward=40;
    printf("\nMain Menu");
    printf("\n1.Browse new website(Push)");
    printf("\n2.Back");
    printf("\n3.Forward");
    printf("\n4.Display status");
    printf("\n5.Exit");
    do
    {
        printf("\n  Enter choice:");
        scanf("%d",&ch);
        switch(ch)
        {
            case 1: b_push_new(); break;
            case 2:
                    if(st.back==0)
                    printf("\nNo history available");
                    else
                    {
                        f_push();
                        b_pop();
                    }
                    break;
            case 3:
                    if(st.forward==40)
                    printf("\nNo forward history available");
                    else
                    {
                        b_push();
                        f_pop();
                    }
                    break;
            case 4: display();
                    break;
            case 5: break;
            default:printf("\nInvalid choice! Please try again!");
        }
    }while(ch!=5);
}
