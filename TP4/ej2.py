import numpy as np 
from hopfield import Hopfield
from TP4.utils.letters import LETTERS_BITS


def noise_letter(letter, p, preserve_letter):
    letter_bits = LETTERS_BITS[letter.upper()]

    result = [i for row in letter_bits for i in row]
    for i in range(len(result)):
        if p > np.random.uniform(0, 1):
            if result[i] == -1:
                result[i] = 1
            elif not preserve_letter:
                result[i] = -1

    return result


def parse(filename):
    result = []

    with open(filename, 'r') as f:
        chars = f.read()
        letters = 0
        lines_count = 0
        line_c_count = 0

        for i in range(len(chars)):
            c = chars[i]

            if c != '\n':
                if lines_count >= 5:
                    letters += 1
                    lines_count = 0
                    line_c_count = 0

                if c == '*':
                    value = 1
                else:
                    value = -1
                line_c_count += 1
                result = np.append(result, value)
            else:
                lines_count += 1

        letters += 1
    return result.reshape(letters, 5*5)


def run():
    pattern = parse('data/letter_patterns.txt')
    hp = Hopfield(pattern)

    test_pattern = noise_letter("J", 0.4, True)
    hp.train(test_pattern, 10)


if __name__ == '__main__':
    run()
