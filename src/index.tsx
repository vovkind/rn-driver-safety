import { NativeModules } from 'react-native';

type RnDriverSafetyType = {
  multiply(a: number, b: number): Promise<number>;
};

const { RnDriverSafety } = NativeModules;

export default RnDriverSafety as RnDriverSafetyType;
