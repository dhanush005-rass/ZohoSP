def removeTrail00(string):
    return string.rstrip('0')
print(removeTrail00("1203000"))  # Output: "1203"
print(removeTrail00("0000"))     # Output: ""
print(removeTrail00("12345"))    # Output: "12345"
