mod command_line;
mod bruteforce;

fn main() {
    let (password, min_length, max_length) = command_line::get_arguments();

    let result = bruteforce::guess_password(password, min_length, max_length);

    println!("Cracked the password in {} guesses!", result);
}