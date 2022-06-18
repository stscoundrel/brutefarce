use std::convert::TryFrom;
use rand::{distributions::Alphanumeric, Rng};

fn get_guess_length(min_length: u32, max_length: u32) -> usize {
    if min_length == max_length {
        return usize::try_from(min_length).unwrap();
    }

    let guess: u32 = rand::thread_rng()
        .gen_range(min_length..max_length+1);
        
    usize::try_from(guess).unwrap()
}

fn make_a_guess(length: usize) -> String {
    rand::thread_rng()
        .sample_iter(&Alphanumeric)
        .take(length)
        .map(char::from)
        .collect()
}

pub fn guess_password(password: String, min_length: u32, max_length: u32) -> i32 {
    let mut guesses: i32 = 1;
    let mut is_not_cracked: bool = true;

    while is_not_cracked {
        let guess_length = get_guess_length(min_length, max_length);
        let guess: String = make_a_guess(guess_length);

        if guess == password {
            is_not_cracked = false;
        }

        guesses += 1;

        println!("{} guess is: {}", guesses, guess);
    }

    guesses
}