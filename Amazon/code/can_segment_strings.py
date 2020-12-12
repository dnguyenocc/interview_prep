def can_segment_string(s, dictionary):
    """
    
    """
    for i in range(len(s)):
        first_word = s[:i]
        second_word = s[i:]
        if first_word in dictionary:
            if second_word in dictionary or len(second_word) == 0:
                return True
            return can_segment_string(second_word, dictionary)
    return False


dictionary = {
    "apple", "pear", "pie"
}

print(can_segment_string("applepie", dictionary))
print(can_segment_string("applepeer", dictionary))
