def validate(orgcd, atcd):
    hit = 0
    nearhit = 0

    if len(orgcd) != len(atcd):
        print("The length of orgcd and atcd are not equal")
        return

    freq_orgcd = {}
    freq_atcd = {}

    # First, count hits and build frequency dictionaries
    for i in range(len(orgcd)):
        if orgcd[i] == atcd[i]:
            hit += 1
        else:
            freq_orgcd[orgcd[i]] = freq_orgcd.get(orgcd[i], 0) + 1
            freq_atcd[atcd[i]] = freq_atcd.get(atcd[i], 0) + 1

    # Calculate near hits (common elements in wrong positions)
    for item in freq_atcd:
        if item in freq_orgcd:
            nearhit += min(freq_atcd[item], freq_orgcd[item])

    print(f"Exact hits: {hit}")
    print(f"Near hits: {nearhit}")
orgcd = ['A', 'B', 'C', 'D']
atcd  = ['A', 'C', 'B', 'E']

validate(orgcd, atcd)
