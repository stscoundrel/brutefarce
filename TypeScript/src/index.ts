import bruteforcePassword from './bruteforce';

const main = () => {
  const args = process.argv;
  const password: string = args[2];
  const minLength: number = parseInt(args[3]);
  const maxLength: number = parseInt(args[4]);

  const result = bruteforcePassword(password, minLength, maxLength);

  console.log(`Cracked the password in ${result} guesses!`);
}

main();