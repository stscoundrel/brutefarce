use std::env;

pub fn get_arguments() -> (String, u32, u32) {
    let args: Vec<String> = env::args().collect();
    let password: String = args[1].to_string();
    let min_length: u32 = args[2].parse().unwrap();
    let max_length: u32 = args[3].parse().unwrap();

    (password, min_length, max_length)
}