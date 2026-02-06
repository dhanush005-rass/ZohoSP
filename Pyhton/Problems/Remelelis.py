def remele(lst):
    while len(lst) > 0:
        print("Current list:", lst)
        digit = input("Enter the digit to remove (0-9): ")

        new_lst = []
        for number in lst:
            # Convert number to string, remove all occurrences of the digit
            new_number_str = str(number).replace(digit, "")

            if new_number_str != "":
                new_lst.append(int(new_number_str))  # Keep the number if digits remain

        lst = new_lst  # Update the list for next iteration

    print("All numbers have been emptied!")
