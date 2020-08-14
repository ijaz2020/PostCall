# Enter your code here. Read input from STDIN. Print output to STDOUT
# Interference

import itertools

wiki = raw_input()
questions = [raw_input() for i in xrange(5)]
original_answers = raw_input().split(';')
answers = [a for a in original_answers]
assert(len(answers) == 5)
punctuation = [',',':',';','?','!']

def clean(words):
  for i in range(len(words)):
    for p in [',',':',';','?','!']:
      words[i] = words[i].replace(p,' ')
      for letter in words[i]:
        if letter.isupper(): words[i].replace(letter, letter.lower())
  return words

min_length = 2
discard = ['and','with','through','the','that','which','who','why','what', 'when','whose','whom','where','some','their','his','her','any','from','for','then','than','also','did','to','in','at','on','an','but']

questions = clean(questions)
answers = clean(answers)
sentences = []
for sentence in wiki.split('.'):
  words = clean([w for w in sentence.split() if len(w) >= min_length and not w in discard])
  if len(words) > 0: sentences += [words]


def get_substrings(w,length):
  return [w[start:start+length] for start in range(len(w)+1-length)]


def similarity(word1,word2):
  match = 0
  if len(word1) <= len(word2): w1, w2 = (word1, word2)
  else: w1, w2 = (word2, word1)
  for l in range(3,len(w1)+1):
    for substr in get_substrings(w1, l):
      if substr in w2: match = l
  return 2*float(match) / (len(w1) + len(w2))

def filter(words, already_treated):
  filtered_words = [] # watch out that keywords do not contain similar words multiple times
  for w1 in words:
    if w1 in discard: continue
    sim = [similarity(w1,w2) for w2 in filtered_words]
    if len(sim) == 0 or max(sim) < 0.6: filtered_words += [w1]
  return filtered_words


def get_overlaps(words, sentence):
  get_max = lambda x: 0. if len(x) == 0 else max(x)
  return [get_max ([similarity(w1,w2) for w2 in sentence if similarity(w1,w2) > 0.3]) for w1 in words]


def get_matches (words, weight):
  keys = filter([w for w in words.split() if len(w) >= min_length],[])
  matches = [] # how well each sentence matches the words to find
  for sentence in sentences:
    overlaps = get_overlaps(keys, sentence)
    matches +=[sum([ overlaps[i]*weight(keys[i]) for i in range(len(overlaps))])]
  return [m / sum([weight(w) for w in keys]) for m in matches]


question_matches = [get_matches(question, lambda w: 1.) for question in questions]
answer_matches = [get_matches(answer, lambda w: 1.) for answer in answers]

all_ratings = [] # first index denotes the question, second index denotes the answer
for q in range(5):
  points = []
  for a in range(5):
    points += [max([question_matches[q][i] * answer_matches[a][i] for i in range(len(sentences))])]
  all_ratings += [points]

#for a in answers: print a
#for q in range(5): print all_ratings[q]

best_match = (range(5), sum([all_ratings[i][i] for i in range(5)]))
for perm in itertools.permutations(range(5)):
  value = sum([all_ratings[i][perm[i]] for i in range(5)])
  if value > best_match[1]: best_match = (perm, value)

for i in best_match[0]: print original_answers[i]
