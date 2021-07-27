mod command_line;

fn main() {
    let (password, min_length, max_length) = command_line::get_arguments();

    println!("{} {} {}", password, min_length, max_length);
}