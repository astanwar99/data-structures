#include <stdio.h>
#include <stdlib.h>

struct node
{
    struct node *prev;
    int rollno;
    struct node *next;
}*h,*t,*temp,*temp1,*temp2;

void insert();
void show();
void search();
void delete();

int count = 0;

void main()
{
    int ch;

    h = NULL;
    temp = temp1 = NULL;
    printf("\n\tMAIN MENU");
    printf("\n 1 - Insert at beginning");
    printf("\n 2 - Display entire contents");
    printf("\n 3 - Search and delete and display predecessor and successor element");
    printf("\n 4 - Exit");

    while (1)
    {
        printf("\n Enter choice : ");
        scanf("%d", &ch);
        switch (ch)
        {
        case 1:
            insert();
            break;
        case 2:
            display();
            break;
        case 3:
            search();
            break;
        case 4:
            exit(0);
        default:
            printf("\n Invalid Choice! Please try again!");
        }
    }
    h->next=t;
    t->prev=h;
}

/* To create an empty node */
void create()
{
    int data;
    temp =(struct node *)malloc(1*sizeof(struct node));
    temp->prev = NULL;
    temp->next = NULL;
    printf("\n Enter rollno to enter : ");
    scanf("%d", &data);
    temp->rollno = data;
    count++;
}

/*  To insert at beginning */
void insert()
{
    if (h == NULL)
    {
        create();
        h = temp;
        temp1 = h;
    }
    else
    {
        create();
        temp->next = h;
        h->prev = temp;
        h = temp;
    }
}

/* To delete the needed element */
void delete(int pos)
{
    int i = 1;
    temp2 = h;
    int p=pos;
    if ((pos < 1) || (pos >= count + 1))
    {
        printf("\n Error : Position out of range to delete");
        return;
    }
    if (h == NULL)
    {
        printf("\n Error : Empty list no elements to delete");
        return;
    }
    else
    {
        while (i < pos)
        {
            temp2 = temp2->next;
            i++;
        }
        if (i == 1)
        {
            if (temp2->next == NULL)
            {
                printf("Node deleted from list");
                free(temp2);
                temp2 = h = NULL;
                return;
            }
        }
        if (temp2->next == NULL)
        {
            temp2->prev->next = NULL;
            free(temp2);
            printf("Node deleted from list");
            return;
        }
        temp2->next->prev = temp2->prev;
        if (i != 1)
            temp2->prev->next = temp2->next;
        if (i == 1)
            h = temp2->next;
        printf("\n Node deleted");
        free(temp2);
    }
    count--;
    show(p);
}

/* Display from beginning */
void show(int n)
{
    temp2 = h;
    int i;
    if (temp2 == NULL)
    {
        printf("List empty!\n");
        return;
    }
    else
    {
        for(i=0;i<n-2;i++)
        {
            temp2=temp2->next;
        }
    }
    printf("\n Predecessor: %d",temp2->rollno);
    temp2=temp2->next;
    printf("\n Successor: %d",temp2->rollno);
}

/* To search for an element in the list */
void search()
{
    int data, count = 0;
    temp2 = h;

    if (temp2 == NULL)
    {
        printf("\n Error : List empty to search for data");
        return;
    }
    printf("\n Enter rollno to search for : ");
    scanf("%d", &data);
    while (temp2 != NULL)
    {
        if (temp2->rollno == data)
        {
            printf("\n Data found in %d position",count + 1);
            break;
        }
        else
             temp2 = temp2->next;
            count++;
    }
    delete(count+1);
    if (count==0)
        printf("\n Error : %d not found in list", data);
}

void display()
{
    temp2 = h;

    if (temp2 == NULL)
    {
        printf("\nList empty!\n");
        return;
    }
    printf("\n Linked list elements : ");

    while (temp2->next != NULL)
    {
        printf(" %d ", temp2->rollno);
        temp2 = temp2->next;
    }
    printf(" %d ", temp2->rollno);
}
