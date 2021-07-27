use std::convert::TryFrom;
use rand::{distributions::Alphanumeric, Rng};

fn get_guess_length(min_length: u32, max_length: u32) -> usize {
    let guess: u32 = rand::thread_rng()
        .gen_range(min_length..max_length);
        
    usize::try_from(guess).unwrap()
}

pub fn guess_password(password: String, min_length: u32, max_length: u32) -> i32 {
    let mut guesses: i32 = 1;
    let mut is_not_cracked: bool = true;

    while is_not_cracked {
        let guess_length = get_guess_length(min_length, max_length);

        let guess: String = rand::thread_rng()
            .sample_iter(&Alphanumeric)
            .take(guess_length)
            .map(char::from)
            .collect();

        if guess == password {
            is_not_cracked = false;
        }

        guesses += 1;

        println!("{} guess is: {}", guesses, guess);
    }

    guesses
}