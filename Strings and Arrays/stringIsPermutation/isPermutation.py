# checks if two strings are permutations of the other

def main():
    print('\n' + 'playground : lpaygruodn -> ' + str(isPermutation('playground', 'lpaygruodn')) + '\n')
    print('hello : hello -> ' + str(isPermutation('hello', 'hello')) + '\n')
    print('world : dlrow -> ' + str(isPermutation('world', 'dlrow')) + '\n')
    print('123 : 1234 -> ' + str(isPermutation('123', '1234')) + '\n')

def isPermutation(string1, string2):
    if len(string1) == len(string2):
        matchCount = 0
        for c in string1:
            if c in string2:
                matchCount += 1
        if matchCount == len(string1):
            return True
    return False

if (__name__ == '__main__'):
  main()
