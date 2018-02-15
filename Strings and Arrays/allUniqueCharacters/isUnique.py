# checks if a string contans all unique characters

def main():
    print('\n' + 'playground: ' + str(isUnique('playground')) + '\n')
    print('hello: ' + str(isUnique('hello')) + '\n')
    print('world: ' + str(isUnique('world')) + '\n')
    print(' : ' + str(isUnique(' ')) + '\n')
    print('  : ' + str(isUnique('  ')) + '\n')
    print('supercalifragilisticexpialidocious: ' + str(isUnique('supercalifragilisticexpialidocious')) + '\n')

def isUnique(chars):
    if len(chars) >= 128:
        return False

    seen = []
    for c in chars: 
        if(c in seen):
            return False
        seen.append(c)
    return True

if (__name__ == '__main__'):
  main()