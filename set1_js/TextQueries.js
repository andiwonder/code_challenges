function query(texts, phrases) {
  let matches = [];
  let texts_split = texts.map(text => {
    return text.split(' ');
  });

  texts.map((text, text_index) => {
    phrases.map((phrase, phrase_index) => {
      let all_match = true;
      let hits = [];
      phrase.map(query => {
        console.log('query is ' + query);
        // console.log(text);
        if (all_match != false && text.indexOf(query) == -1) {
          hits.push(text_index);
        } else {
          all_match = false;
        }
      });
      console.log('hits is ' + hits);
      matches.push(hits);
    });
    console.log('new text');
  });

  // console.log('matches ' + matches);
}

let texts = ['bob and alice like to text each other', 'bob does not like to ski', 'alice likes to ski'];
let phrases = [['bob', 'alice'], ['alice'], ['like'], ['hello']];
// let texts = ['bob and alice like to text each other', 'hello'];
// let phrases = [['bob', 'alice']];
console.log(phrases);
query(texts, phrases);
