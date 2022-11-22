package Inteli_Singly_Linked_List_Package;

public class InteliSinglyLinkedClass<DataType> {

    private Inteli_Node<DataType> head;

    public int count = 0;




    public void Add(DataType data)
    {
        if (head == null)
        {
            head = new Inteli_Node<DataType>(data);
        }
        else
        {
            Inteli_Node<DataType> navigation_node = head;

            while (navigation_node.next != null)
            {
                navigation_node = navigation_node.next;

                if(navigation_node.next != null)
                {
                    navigation_node = navigation_node.next;
                }
            }

            navigation_node.next = new Inteli_Node<DataType>(data);
        }

        count++;
    }

    public void Add(DataType data, int index)
    {
        if(index == count || (count == 0 && index == 0))
        {
            Add(data);
        }
        else if(index >= 0 && index < count)
        {
            int current_index = 0;

            Inteli_Node<DataType> navigation_node = head;

            while (current_index < index)
            {
                navigation_node = navigation_node.next;
                current_index++;

                if(current_index + 1 < index)
                {
                    navigation_node = navigation_node.next;
                    current_index++;
                }
            }

            navigation_node.data = data;
        }
        else
        {
            throw new IndexOutOfBoundsException("Index was outside of the bounds of the list");
        }
    }

    public DataType GetElementAtIndex(int index)
    {
        DataType return_data;

        if(count - 1 >= 0 && index >= 0)
        {
            int current_index = 0;

            Inteli_Node<DataType> navigation_node = head;

            while (current_index < index)
            {
                navigation_node = navigation_node.next;
                current_index++;

                if(current_index + 1 < index)
                {
                    navigation_node = navigation_node.next;
                    current_index++;
                }
            }

            return_data = navigation_node.data;

        }
        else {
            throw new IndexOutOfBoundsException("Index was outside of the bounds of the list");
        }

        return return_data;
    }


    public void Clear()
    {
        Inteli_Node<DataType> navigation_node = head;
        head.data = null;

        while (navigation_node.next != null)
        {
            navigation_node.data = null;
            navigation_node = navigation_node.next;

            if(navigation_node.next != null)
            {
                navigation_node.data = null;
                navigation_node = navigation_node.next;
            }
        }

        navigation_node.data = null;
        count = 0;
        head = null;

    }



}
