import bruteforce_password from './bruteforce';

const main = () => {
  const args = process.argv;
  const password: string = args[2];
  const min_length: number = parseInt(args[3]);
  const max_length: number = parseInt(args[4]);

  const result = bruteforce_password(password, min_length, max_length);

  console.log('Result is '+result)
}

main();