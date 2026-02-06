def evenlenvow(str):
    words=str.split()
    vowels="aeiouAEIOU"
    for word in words:
        if len(word)%2==0 and word[0]in vowels:
            return word
    return "00"
print(evenlenvow("The sun sets in the east"))
print(evenlenvow("Hello World"))