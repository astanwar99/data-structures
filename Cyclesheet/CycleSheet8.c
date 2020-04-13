// SHIVAM PAUL
// 17BIT0328
/*8. a) There is a garage where the access road can accommodate any number of trucks at one time. The garage is built in such a way that only the last truck entered can be moved out. Each of the trucks is identified by a positive integer (a truck_id). Implement dynamically to handle truck moves, allowing for the following commands:
i) On_road (truck_id); ii) Enter_garage (truck_ id);
iii) Exit_garage (truck_id); iv) Show_trucks (garage or road);
If an attempt is made to get a truck out which is not the closest to the garage entry, the error message “Truck x cannot be moved” should be displayed.*/

#include<stdio.h>

struct stack
{
    int truck_id;
    struct stack *next;
}*top,*temp;

void st_empty()
{
    if(top->data===NULL)
        return 1;
    else return 0;
}

void st_push()
{
    int t;
    scanf("%d",&t);
    if(top->next==NULL)
        top->truck_id=t;
    else
    {
        temp->next=top;
        temp->truck_id=t;
        top=temp;
    }
}
//will display all the trucks on the road, i.e, other than the truck that was entered first
void disp_road()
{
    if (st_empty==1)
        printf("\nThere are no trucks!");
    else
    {
        temp=st.top;
        while(temp!=NULL)
        {
            printf("TruckID %d",temp->data);
            temp=temp->next;
        }
    }

}

void st_find()
{
    int n;
    printf("\nEnter truckID:");
    scanf("%d",&n);
    if (n==st.)     //COMPLETE    //CHECK FOR ST.sth or basically check the name of the structure if it agrees with the rest of the program or not
    printf("\nTruck taken out successfully!");
    else
    printf("\nTruck %d cannot be moved out!",n);
}
void main()
{
    nw=(struct node*)malloc(sizeof(struct node));
    nw->data=NULL;
    nw->top=NULL;
    top=(struct stack*)malloc(sizeof(struct stack));
    temp=(struct stack*)malloc(sizeof(struct stack));
    top=nw;
    int no,ch,;
    printf("Main Menu");
    printf("\n1. Enter truck");
    printf("\n2. Exit truck");
    printf("\n3. Show trucks on the access road:");
    printf("\n4. Get trucks on the access road and garage:");
    printf("\n5. Get XXXX truck out:");
    printf("\n6. Exit");
    do
    {
        scanf("%",&ch);
        switch(ch)
        {
            case 1: st_push(); break;
            case 2: st_pop(); break;
            case 3: st_disp_road(); break;
            case 4: st_disp_all(); break;
            case 5: st_find(); break;
            case 5: break;
            default: printf("\nInvalid Choice!"); break;
        }
    }
}

