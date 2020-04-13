//SHIVAM PAUL
//17BIT0328
//CREATED ON 13/12/2017
//Cycle Sheet Question 1

#include<stdio.h>
struct stack
{
   int top;
   int a[30];
}st;

void st_push()
{
    int id;
    if(st.top==29)
    printf("\nStack Overflow!");
    else
    {
        printf("\nEnter register number to be pushed:\t");
        scanf("%d",&id);
        //st.top++;
        st.a[++st.top]=id;
    }
}

void disp()
{
    int i;
    for(i=1;i<st.top+1;i++)
    printf("\n%d",st.a[i]);
}

void st_pop()
{
    if(st.top==-1)
    printf("\nStack underflow!");
    else
    {
        printf("\nDeleted register number:",st.a[st.top]);
        st.top--;
    }
}

void display()
{
    int i,n;
    for(i=1;i<11;i++)
    printf("\n%d",st.a[i]);
}

void dupli()
{
    int i,ind,j,k,temp,flag=0;
    for(i=0;i<st.top;i++)
    {
        for(j=i+1;j<st.top;j++)
        if (st.a[i]==st.a[j])
        {
            for(k=j;k<st.top;k++)
            {
                st.a[k]=st.a[k+1];
            }
            st.top--;
        }
    }

}
int main()
{
    int top=-1;
    int n,ch,n1,i;
    do
    {
        printf("\n1.Enter register number:\n2. Delete register number:\n3. Display first 10 register numbers:\n4. Display the register number of student who submitted last:\n5. Display complete stack\n6. Find and delete repeated entries\n7. Exit:\t");
        scanf("%d",&ch);
        switch(ch)
        {
            case 1:
            {
                printf("\nEnter no of register numbers to be pushed:\t");
                scanf("%d",&n1);
                for(i=0;i<n1;i++)
                st_push();
                break;
            }
            case 2:
            {
                printf("\nEnter number of register numbers to be popped:");
                scanf("%d",&n1);
                for(i=0;i<n1;i++)
                st_pop();
                break;
            }
            case 3:
            {
                display();
                break;
            }
            case 4: printf("%d",st.a[st.top]); break;
            case 5: disp(); break;
            case 6: dupli(); break;
            case 7: break;
            default: printf("\nInvalid choice! Try again!");
        }
    }while(ch!=7);
    return 0;
}
