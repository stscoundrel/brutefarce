const ALPHANUMERIC: string = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

function getGuessLength(minLength: number, maxLength: number): number {
  const length: number = Math.floor(Math.random() * maxLength);

    if( length < minLength ) {
        return minLength;
    }

    return length;
}

function getRandomCharacter(): string {
  const randomPosition = Math.floor(Math.random() * ALPHANUMERIC.length);

  return ALPHANUMERIC.charAt(randomPosition);
}

export default function bruteforcePassword(password: string, minLength: number,  maxLength: number) : number {  
  let isNotCracked: boolean = true;
  let guesses: number = 1;

  while(isNotCracked) {
      const length = getGuessLength(minLength, maxLength);
      let currentGuess = '';

      for(let i = 0; i < length; i += 1){
        currentGuess = currentGuess.concat(getRandomCharacter());
      }
      console.log(`${guesses} guess is: ${currentGuess}`);

      if(password === currentGuess) {
          console.log('Found a match!!');
          console.log(currentGuess);
          isNotCracked = false;
      }

      guesses++;
  }

  return guesses;
} 